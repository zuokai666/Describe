package com.lintcode._190708;

public class Node {
	
	public int x;
	public int y;
	
	public Node(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}