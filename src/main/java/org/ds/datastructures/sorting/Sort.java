package org.ds.datastructures.sorting;

public class Sort {

	
	public int[] bubbleSort(int array[]) {
		boolean swapped = false;
		for(int i=0; i<array.length; i++) {
			swapped = false;
			for(int j=0; j<array.length -1 ; j++) {
				if(array[j] > array[j+1]) {
					swapped = true;
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	public int[] selectionSort(int array[]) {
		
		for(int i=0; i< array.length-1; i++) {
			int minIdx = i;
			for(int j= i+1; j<array.length; j++) {
				if(array[minIdx] > array[j]) {
					minIdx = j;
				}
			}
			int temp = array[minIdx];
			array[minIdx] = array[i];
			array[i]  = temp;
		}
		return array;
	}
	
	public int[] insertionSort(int array[]) {
		
		for(int i=1; i < array.length; ++i) {
			
			int key = array[i];
			int j = i - 1;
			while(j>=0 && array[j]>key) {
				array[j+1] = array[j];
				j = j - 1;
			}
			array[j + 1 ] = key;
		}
		return array;
	}
	
	public int[] mergeSort(int array[], int l, int r) {
		
		if (l < r) {
			int mid = (l + r) / 2;

			mergeSort(array, l, mid);
			mergeSort(array, mid + 1, r);
			merge(array, l, mid, r);
		}
		return array;
		
	}
	
	private int[] merge(int array[], int l, int m, int r) {
		int n1 = (m - l) + 1;
		int n2 = r - m;
		
		int[] subArray1 = new int[n1];
		int[] subArray2 = new int[n2];
		
		for(int i=0; i<subArray1.length; i++) {
			subArray1[i] = array[l + i];
		}
		for(int j=0; j<subArray2.length; j++) {
			subArray2[j] = array[m+1+j];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while(i < n1 && j < n2) {
			
			if(subArray1[i] < subArray2[j]) {
				array[k] = subArray1[i];
				i++;
			}else {
				array[k] = subArray2[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			array[k] = subArray1[i];
			i++;
			k++;
		}
		while(j<n2) {
			array[k] = subArray2[j];
			j++;
			k++;
		}
		return array;
		
	}
	
	public int[] quickSort(int array[], int l, int r) {
		if (l < r) {
			int pi = partition(array, l, r);
			quickSort(array, l, pi - 1);
			quickSort(array, pi + 1, r);
		}
		return array;
	}
	private int partition(int array[], int l, int r) {
		
		int pivote = array[r];
		int i = l - 1;
		
		for (int j=l; j<r;j++) {
			
			if(array[j] <= pivote) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		
		int temp = array[i+1];
		array[i+1] = pivote;
		array[r] = temp;
		return i+1;
	}
}
