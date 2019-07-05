package com.lintcode._190702;

public class TreeNode {

	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(left == null){
			sb.append("left=null,");
		}else {
			sb.append("left=");
			sb.append(left.val);
			sb.append(",");
		}
		sb.append(val);
		sb.append(",");
		if(right == null){
			sb.append("right=null");
		}else {
			sb.append("right=");
			sb.append(right.val);
		}
		return sb.toString();
	}
}