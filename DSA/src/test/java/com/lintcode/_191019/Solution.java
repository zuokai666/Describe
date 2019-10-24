package com.lintcode._191019;

import java.util.Stack;

public class Solution {

	public int trainCompartmentProblem(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        Stack<Integer> st = new Stack<>();
		int result = 0;
		int index = 0;
		for (int i = 1; i <= n; ++i) {
            st.push(i);
			result = Math.max(result, (int)st.size() - 1);
		    while(!st.empty() && st.peek() == arr[index]) {
		       st.pop();
			   index++;
		    }
		}
		if (!st.empty()) {
		    return -1;
        }
		return result;
    }
}
