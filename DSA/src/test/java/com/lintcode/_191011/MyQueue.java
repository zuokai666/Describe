package com.lintcode._191011;

import java.util.Stack;

public class MyQueue {
	
	private Stack<Integer> stack;
	
    public MyQueue() {
    	this.stack = new Stack<>();
    }
    
    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
    	stack.push(element);
    }
    
    /*
     * @return: An integer
     */
    public int pop() {
    	Stack<Integer> temp = new Stack<>();
    	while(!stack.isEmpty()){
    		temp.push(stack.pop());
    	}
    	int result = temp.pop();
    	while(!temp.isEmpty()){
    		stack.push(temp.pop());
    	}
		return result;
    }

    /*
     * @return: An integer
     */
    public int top() {
    	Stack<Integer> temp = new Stack<>();
    	while(!stack.isEmpty()){
    		temp.push(stack.pop());
    	}
    	int result = temp.peek();
    	while(!temp.isEmpty()){
    		stack.push(temp.pop());
    	}
		return result;
    }
}