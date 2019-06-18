package com.list.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zk.util.TimeTemplate;

public class Test {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		DataOperator.addInt(list);
		TimeTemplate.count(new Runnable() {
			public void run() {
				forList(list);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TimeTemplate.count(new Runnable() {
			public void run() {
				forList2(list);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		TimeTemplate.count(new Runnable() {
			public void run() {
				iteratorList(list);
			}
		});
	}
	
	public static void forList(ArrayList<Integer> list){
		for(int i=0;i<list.size();i++){
			list.get(i);
		}
	}
	public static void forList2(List<Integer> list){
		for(@SuppressWarnings("unused") Integer i:list){
		}
	}
	
	public static void iteratorList(ArrayList<Integer> list){
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next();
		}
	}
}