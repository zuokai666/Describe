package com.endian.test;

import java.nio.ByteOrder;

/**
 * ByteOrder 字节序
 * 
 * 内部使用sun.misc.Unsafe
 * 
 * @author king
 * @date 2019-06-30 00:49:39
 * 
 */
public class EndianTest {
	
	public static void main(String[] args) {
		System.err.println(ByteOrder.nativeOrder());
	}
}