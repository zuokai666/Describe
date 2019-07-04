package com.lintcode._190704;

import java.util.LinkedList;
import java.util.Queue;

import com.lintcode._190702.TreeNode;

public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
    	if(root == null) return null;
    	StringBuilder sb = new StringBuilder();
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	int index = -1;
    	while(!queue.isEmpty()){
    		TreeNode node = queue.poll();
    		if(node != null){
       			sb.append(node.val);
       			index = sb.length();
       			queue.add(node.left);
       			queue.add(node.right);
       		}else {
       			sb.append("#");
			}
    		sb.append(",");
    	}
    	String result = sb.toString();
		return result.substring(0, index);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
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
				if(i % 2 == 0 && 0 <= parent){
    				nodes[parent].right = node;
    			}else {
    				nodes[parent].left = node;
				}
			}
    	}
		return nodes[0];
    }
}