package org.ds.datastructures.heap;

import java.util.Arrays;

public class MaxHeap {

	private int[] heap;
	private int size;
	public MaxHeap(int[] array) {
		size = array.length;
		heap = Arrays.copyOf(array, size);
	}
	
	private void buildMaxHeap() {
		for(int i  = (size / 2 ) - 1  ; i>=0; i--) {
			maxHeapify(i);
		}
	}
	private void maxHeapify(int index) {
		int largest = index;
		int leftIndex = 2 * index  + 1  ;
		int rightIndex = 2 * index + 2;
		
		if( leftIndex < size ) {
			int temp1 = heap[index];
			int temp2 = heap[leftIndex];
			if( temp1 < temp2 )
				largest = leftIndex;
		}
		if( rightIndex < size ) {
			int temp1 = heap[largest];
			int temp2 = heap[rightIndex];
			if (temp1 < temp2)
				largest = rightIndex;
		}
		if( largest != index) {
			swap(index, largest);
			maxHeapify(largest);
		}
		
	}
	private void swap(int firstIndex, int secondIndex) {
		int temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;
	}
	
	private void insertElement(int data) {
		
		heap = Arrays.copyOf(heap, size+1);
		int i = size;
		int parentIndex = ( i - 1 ) / 2;
		while(i > 0 && data > heap[parentIndex]) {
			heap[i] = heap[parentIndex];
			i = parentIndex;
			parentIndex = (i - 1) / 2;
		}
		heap[i] = data;
		size++;
	}
	
	private int deleteMax() {
		if(heap == null || heap.length == 0)
			return -1;
		
		int data = heap[0];
		heap[0] = heap[size - 1];
		size--;
		heap = Arrays.copyOf(heap, size);
		maxHeapify(0);
		return data;
	}
	
	private void printHeap() {
		if( heap == null)
			System.out.print("null");
		int iMax = size -1 ;
		if(iMax == -1) {
			System.out.print("[]");
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < heap.length; i++) {
			sb.append(heap[i]);
			sb.append(", ");
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		int[] inputElements = {5,12,64,1,37,90,91,97};
		MaxHeap maxHeap = new MaxHeap(inputElements);
		maxHeap.printHeap();
		maxHeap.buildMaxHeap();
		System.out.println();
		maxHeap.printHeap();
		maxHeap.insertElement(98);
		System.out.println();
		maxHeap.printHeap();
		System.out.println("Max element deleted "+ maxHeap.deleteMax());
		System.out.println();
		maxHeap.printHeap();
		System.out.println("Max element deleted "+ maxHeap.deleteMax());
		maxHeap.printHeap();


	}
}
