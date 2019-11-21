package org.zk.mysql.primary.test;

import java.util.UUID;

public class UUIDGenerator implements IdGenerator {
	
	@Override
	public String generateId() {
		return UUID.randomUUID().toString();
	}
}