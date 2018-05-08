package org.ds.datastructures.sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

	private Sort sort;
	private int array[] = {5, 1, 4, 2, 8 };
	private int expected[] = { 1, 2, 4, 5, 8 };
	@Before
	public void setUp() {
		sort = new Sort();
	}
	
	@Test
	public void testBubbleSort() {
		assertArrayEquals( expected, sort.bubbleSort( array ));
	}
	@Test
	public void testSelectionSort() {
	
		assertArrayEquals( expected, sort.selectionSort(array));
	}
	
	@Test
	public void testInsertionSort() {
		assertArrayEquals( expected, sort.insertionSort( array ));
	}
	@Test
	public void testMergeSort() {
		int[] actual = sort.mergeSort(array, 0, array.length - 1);
		assertArrayEquals( expected, actual );
	}
	@Test
	public void testQuickSort() {
		int[] actual = sort.quickSort(array, 0, array.length -1);
		assertArrayEquals( expected, actual );
	}
	
}
