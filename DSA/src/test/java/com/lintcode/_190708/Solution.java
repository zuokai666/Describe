package com.lintcode._190708;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// https://www.jianshu.com/p/bb123944d3e5
public class Solution {

	public static void main(String[] args) {
		new Solution().solveNQueens(4);
	}

    public void solveNQueens(int n) {
    	int[][] arr = new int[n][n];
    	List<List<String>> result = new ArrayList<>();
    	//将第一个(0,0)入栈
    	Stack<Node> stack = new Stack<>();
    	stack.push(new Node(0, 0));
    	
    }
    
    public boolean judgeSuccessIfPut(int[][] arr, int x, int y){
    	int n = arr.length;
		for(int i=0;i<n;i++){//判断列是否有值
    		if(arr[i][y] == 1){
    			return false;
    		}
    	}
    	for(int j=0;j<arr[x].length;j++){//判断行是否有值
    		if(arr[x][j] == 1){
    			return false;
    		}
    	}
    	//检查左上到右下斜线
    	int min = x < y ? x : y;
    	int xx = x - min;
    	int yy = y - min;
    	while(xx < n){
    		if(yy < n && arr[xx][yy] == 1){
    			return false;
    		}
    		yy++;
    		xx++;
    	}
    	//检查右上到左下斜线
		return true;
    }
}