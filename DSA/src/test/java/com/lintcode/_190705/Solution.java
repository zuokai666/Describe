package com.lintcode._190705;

import com.lintcode._190702.TreeNode;

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = solution.deserialize("1,2,3,#,#,4,5");
		System.err.println(solution.maxPathSum(root));
	}
	
	int max = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
    	int maxAll = maxPathSumInternal(root);
    	if(maxAll < max){
    		return max;
    	}else {
			return maxAll;
		}
    }
    
    public int maxPathSumInternal(TreeNode root) {
    	if(root == null) return 0;
    	int leftMaxPathSum = maxPathSumInternal(root.left);
    	int rightMaxPathSum = maxPathSumInternal(root.right);
    	int self = leftMaxPathSum + root.val + rightMaxPathSum;
    	if(max < self){
    		max = self;
    	}
    	if(leftMaxPathSum < rightMaxPathSum){
    		return rightMaxPathSum + root.val;
    	}else {
    		return leftMaxPathSum + root.val;
		}
    }
    
    public TreeNode deserialize(String data) {
    	if(data == null) return null;
    	String[] datas = data.split(",");
    	TreeNode[] nodes = new TreeNode[datas.length];
    	for(int i=0;i<datas.length;i++){
    		String str = datas[i];
    		if(str.equals("#")){
    			nodes[i] = null;
    		}else {
    			TreeNode node = new TreeNode(Integer.parseInt(datas[i]));
    			nodes[i] = node;
    			int parent = (i - 1) >> 1;
    			if(0 <= parent){
    				if(i % 2 == 0){
        				nodes[parent].right = node;
        			}else {
        				nodes[parent].left = node;
    				}
    			}
			}
    	}
		return nodes[0];
    }
}