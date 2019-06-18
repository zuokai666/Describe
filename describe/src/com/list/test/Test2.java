package com.list.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.zk.util.TimeTemplate;

public class Test2 {
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new LinkedList<>();
		DataOperator.addInt(list1);
		DataOperator.addInt(list2);
		TimeTemplate.count(new Runnable() {
			public void run() {
				iteratorList(list1);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TimeTemplate.count(new Runnable() {
			public void run() {
				iteratorList(list2);
			}
		});
	}
	
	public static void forList(List<Integer> list){
		for(int i=0;i<list.size();i++){
			list.get(i);
		}
	}
	public static void forList2(List<Integer> list){
		for(@SuppressWarnings("unused") Integer i:list){
		}
	}
	
	public static void iteratorList(List<Integer> list){
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next();
		}
	}
}