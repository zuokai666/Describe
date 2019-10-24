package com.lintcode._191019;

import java.util.HashMap;

public class Solution1 {

	public int[] getAns(int[] op, String[] name, int[] w) {
		int[] result = new int[op.length];
		HashMap<String, Integer> bankMap = new HashMap<>();//姓名，余额
		for(int i=0;i<op.length;i++){
			int balance = bankMap.getOrDefault(name[i], 0);
			if(op[i] == 0){//存钱
				bankMap.put(name[i], balance + w[i]);
				result[i] = balance + w[i];
			}else {//取钱
				if(w[i] <= balance){//可以取钱
					bankMap.put(name[i], balance - w[i]);
					result[i] = balance - w[i];
				}else {
					result[i] = -1;
				}
			}
		}
		return result;
    }
}