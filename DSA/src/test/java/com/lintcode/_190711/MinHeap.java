package com.lintcode._190711;

import com.lintcode._190705.ListNode;

public class MinHeap {

	ListNode[] minHeap = new ListNode[k];
	
	// 堆化有两种，自上而下自左而右的上滤，复杂度是深度和；另一种是自下而上自右而左的下滤，复杂度是高度和，高度和<深度和，所以选择下滤
		private void heapify(ListNode[] minHeap) {
			// 堆化
			int i = (lists.size() - 1 - 1) >> 1;//最后一个需要下滤的节点
			for(;0<=i;i--){
				siftDown(minHeap, i);
			}
		}

		// 上滤
		private void siftUp(ListNode[] minHeap, int i) {

		}

		// 下滤
		private void siftDown(ListNode[] minHeap, int i) {

		}
		
		private ListNode getMin(ListNode[] minHeap){
			return minHeap[0];
		}
		
		
}
