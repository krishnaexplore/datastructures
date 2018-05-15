package org.ds.datastructures.heap;

import java.util.Arrays;

public class MinHeap {

	private int heap[];
	private int size;
	public MinHeap(int[] array) {
		size = array.length;
		heap = Arrays.copyOf(array, size);
	}
	public MinHeap() {
		
	}
	
	public void insertElement(int data) {
		heap = Arrays.copyOf(heap, size+1);
		int i = size;
		int parentIndex = ( i - 1 ) / 2;
		while(i > 0 && data < heap[parentIndex]) {
			heap[i] = heap[parentIndex];
			i = parentIndex;
			parentIndex = (i - 1) / 2;
		}
		heap[i] = data;
		size++;

	}
	private int deleteMin() {
		if(heap == null || heap.length == 0)
			return -1;
		
		int data = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heap = Arrays.copyOf(heap, size);
		heapify(0);
		return data;
	}
	
	public void buildMinHeap() {
		for(int i = (size / 2) - 1; i>=0; i --) {
			heapify(i);
		}
	}
	
	private void heapify(int index) {
		
		int min = index;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		
		if( leftIndex < size ) {
			int temp1 = heap[min];
			int temp2 = heap[leftIndex ];
			if(temp1 > temp2)
			  min = leftIndex;
		}
		if( rightIndex < size ) {
			int temp1 = heap[min];
			int temp2 = heap[rightIndex]; 
			if( temp1 > temp2) {
				min = rightIndex;
			}
		}
		
		if(index != min) {
			swap(index,min);
			heapify(min);
		}
	}
	private void swap(int firstIndex, int secondIndex) {
		int temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;
	}
	
	public void printHeap() {
		for(int i = 0 ; i<heap.length; i++) {
			System.out.print(heap[i] + ", ");
		}
	}
	public static void main(String[] args) {
		int[] inputElements = {5,12,64,1,37,90,91,97};
		MinHeap heap = new MinHeap(inputElements);
		heap.printHeap();
		heap.buildMinHeap();
		System.out.println();
		heap.printHeap();
		heap.insertElement(0);
		System.out.println();
		heap.printHeap();
		heap.deleteMin();
		System.out.println();
		heap.printHeap();
		
	}
}
