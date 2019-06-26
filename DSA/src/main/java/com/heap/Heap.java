package com.heap;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一组记录排序码为(5 11 7 2 3 17),则利用堆排序方法建立的初始堆为(17 11 7 2 3 5)
 * 
 * 求父节点索引：
 * 
 * 堆
 * 
 * 		堆化方法			效率		原因
 * 自上而下自左而右的上滤		低		所有节点的深度之和：高度低的节点占的比例大 	O(nlogn)
 * 自下而上自右而左的下滤		高		所有节点的高度之和：高度低的节点占的比例大	O(n)
 * 
 * 最大堆，最小堆，左式堆
 * 
 * 依赖于动态数组
 * 
 * 左式堆的目的解决问题：为了有效的完成堆合并
 * 节点分布偏向于左侧，合并操作只会涉及到右侧
 * null path length NPL值：建立了一个指标，度量倾斜程度，左倾性
 * 
 */
public class Heap {
	
	public static final Logger log = LoggerFactory.getLogger(Heap.class);
	
	private int[] arr;
	private int size = 0;
	
	/**
	 * 固定容量的堆
	 * 
	 * @param capacity 容量
	 */
	public Heap(int capacity) {
		arr = new int[capacity];
	}
	
	public Heap(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
		heapify();
	}
	
	public void add(int e){
		if(size < arr.length){
			arr[size] = e;
			siftUp(size);
			size++;
		}else {
			log.debug("超过数组容量，不会添加");
		}
	}
	
	public int getMax(){
		return arr[0];
	}
	
	public int delMax(){
		int max = arr[0];
		arr[0] = arr[--size];
		siftDown(0);
		return max;
	}
	
	public int size(){
		return size;
	}
	
	/**
	 * 自下而上自右而左的下滤
	 * 时间复杂度O(n)
	 * 初始化情况下，任何叶节点就是子堆
	 */
	private void heapify(){
		for(int i=(size>>>1 - 1);i>=0;i--){
			siftDown(i);//两个小堆的合并
		}
	}
	
	private void siftUp(int i){
		int k = i;
		while(k > 0){
			int parent = (k - 1) >> 1;
			if(arr[k] <= arr[parent]){
				break;
			}
			int temp = arr[parent];
			arr[parent] = arr[k];
			arr[k] = temp;
			k=parent;
			log.debug(Arrays.toString(arr));
		}
	}
	
	private void siftDown(int i){
		int k = i;
		while(k * 2 + 1 < size){//如果没有左孩子，那就是不用下滤了，因为是完全二叉树，所以没有左孩子就是没有右孩子，就是不用下滤
			int largeChild = k*2+1;//默认左孩子大
			if((k*2+2 < size) && (arr[k*2+1] < arr[k*2+2])){//如果有右孩子，并且右孩子大于左孩子
				largeChild = k*2+2;//看来是右孩子更胜一筹
			}
			if(arr[largeChild] <= arr[k]){
				break;//看来不需要下滤了
			}
			int temp = arr[largeChild];
			arr[largeChild] = arr[k];
			arr[k] = temp;
			k=largeChild;
			log.debug(Arrays.toString(arr));
		}
	}
}