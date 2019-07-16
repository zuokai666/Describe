package com.wrr.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 基于令牌桶的限流算法
 * 
 * @author King
 *
 */
public class RateLimiter {

	//限流时间单位
	private final long rateToMsConversion;
	//当前可供消费的令牌数量
	private final AtomicInteger consumedTokens = new AtomicInteger();
	//上一次填充令牌的时间戳
	private final AtomicLong lastRefillTime = new AtomicLong(0);

	public RateLimiter() {
		this(TimeUnit.SECONDS);
	}

	public RateLimiter(TimeUnit averageRateUnit) {
		switch (averageRateUnit) {
		case SECONDS:
			rateToMsConversion = 1000;
			break;
		case MINUTES:
			rateToMsConversion = 60 * 1000;
			break;
		default:
			throw new IllegalArgumentException("TimeUnit of " + averageRateUnit + " is not supported");
		}
	}

	/**
	 * 
	 * @param burstSize 允许突发事件进入系统的最大请求数
	 * @param averageRate 预期的每秒请求数 
	 * @return
	 */
	public boolean acquire(int burstSize, long averageRate) {
		return acquire(burstSize, averageRate, System.currentTimeMillis());
	}
	
	public boolean acquire(int burstSize, long averageRate, long currentTimeMillis) {
		if (burstSize <= 0 || averageRate <= 0) {
			return true;
		}
		refillToken(burstSize, averageRate, currentTimeMillis);
		return consumeToken(burstSize);
	}
	
	private void refillToken(int burstSize, long averageRate, long currentTimeMillis) {
		long refillTime = lastRefillTime.get();
		long timeDelta = currentTimeMillis - refillTime;

		long newTokens = timeDelta * averageRate / rateToMsConversion;
		if (newTokens > 0) {
			long newRefillTime = refillTime == 0 ? currentTimeMillis
					: refillTime + newTokens * rateToMsConversion / averageRate;
			if (lastRefillTime.compareAndSet(refillTime, newRefillTime)) {
				while (true) {
					int currentLevel = consumedTokens.get();
					int adjustedLevel = Math.min(currentLevel, burstSize); // In
																			// case
																			// burstSize
																			// decreased
					int newLevel = (int) Math.max(0, adjustedLevel - newTokens);
					if (consumedTokens.compareAndSet(currentLevel, newLevel)) {
						return;
					}
				}
			}
		}
	}

	private boolean consumeToken(int burstSize) {
		while (true) {
			int currentLevel = consumedTokens.get();
			if (currentLevel >= burstSize) {
				return false;
			}
			if (consumedTokens.compareAndSet(currentLevel, currentLevel + 1)) {
				return true;
			}
		}
	}

	public void reset() {
		consumedTokens.set(0);
		lastRefillTime.set(0);
	}
}
