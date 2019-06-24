package com.sort;

/**
 * n个数值选出最大m个数（3<m<n）的最小算法复杂度是O(n)
 * 
 * 利用快排的patition思想，基于数组的第k个数来调整，将比第k个数小的都位于数组的左边，
 * 比第k个数大的都调整到数组的右边，这样调整后，位于数组右边的k个数最大的k个数(这k个数不一定是排好序的）
 * 
 * 维持一个大小为m的数组，建立极小堆，时间复杂度为logm,
 * 然后遍历剩下的n-m个元素，若大于堆中最小值，则替换，替换完了进行堆调整。这样复杂度为nlogm。
 * 
 * @author king
 * @date 2019-06-24 22:44:31
 *
 */
public class QuickSort {

}