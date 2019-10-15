package com.lintcode._191015;

import java.util.Stack;

public class MinStack {
	
	private Stack<Integer> datastack = new Stack<Integer>();
	private Stack<Integer> minstack = new Stack<Integer>();
	
    public MinStack() {
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
    	datastack.push(number);
    	if(minstack.isEmpty()){
    		minstack.push(number);
    	}else {
    		if(minstack.peek() <= number){
        		minstack.push(minstack.peek());
        	}else {
        		minstack.push(number);
    		}
		}
    }
    
    /*
     * @return: An integer
     */
    public int pop() {
    	minstack.pop();
    	return datastack.pop();
    }
    
    /*
     * @return: An integer
     */
    public int min() {
    	return minstack.peek();
    }
}