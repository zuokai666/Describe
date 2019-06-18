package com.list.test;

import java.util.List;

public class DataOperator {
	
	public static List<Integer> addInt(List<Integer> list){
		for(int i=0;i<150 * 10000;i++){
			list.add(i);
		}
		return list;
	}
}