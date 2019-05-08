package com.algorithm.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private Sort sort;

    @Before
    public void setUp() throws Exception {
        sort = new Sort();
    }

    @Test
    public void bubbleSort() {
        int[] unSorted = new int[]{5, 4, 3, 2, 1};
        int[] sorted = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(sorted, sort.bubbleSort(unSorted));
    }

    @Test
    public void mergeSort() {
        int[] unSorted = new int[]{5, 4, 3, 2, 1};
        int[] sorted = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(sorted, sort.mergeSort(unSorted));
    }
}
