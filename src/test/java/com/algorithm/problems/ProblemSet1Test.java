package com.algorithm.problems;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ProblemSet1Test {

    private ProblemSet1 problemSet1;

    @Before
    public void setUp() throws Exception {
        problemSet1 = new ProblemSet1();
    }

    @Test
    public void allCellsDistOrder() throws Exception {
        int[][] res1 = problemSet1.allCellsDistOrder(1, 2, 0, 0);
        assertArrayEquals(new int[][]{{0, 0}, {0, 1}}, res1);
    }

    @Test
    public void moveZeroes() throws Exception {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] res = new int[]{1, 3, 12, 0, 0};
        problemSet1.moveZeroes(nums);
        assertArrayEquals(res, nums);
    }

    @Test
    public void findDisappearedNumbers() throws Exception {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = problemSet1.findDisappearedNumbers(nums);
    }

    @Test
    public void numMovesStones() throws Exception {
        int[] num1 = problemSet1.numMovesStones(1, 2, 5);
        assertArrayEquals(new int[]{1, 2}, num1);

        int[] num2 = problemSet1.numMovesStones(2, 4, 1);
        assertArrayEquals(new int[]{1, 1}, num2);

        int[] num3 = problemSet1.numMovesStones(3, 5, 1);
        assertArrayEquals(new int[]{1, 2}, num3);

        int[] num4 = problemSet1.numMovesStones(7, 4, 1);
        assertArrayEquals(new int[]{2, 4}, num4);
    }

    @Test
    public void findUnsortedSubarray() throws Exception {
        int num1 = problemSet1.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        assertEquals(5, num1);

        int num2 = problemSet1.findUnsortedSubarray(new int[]{1, 2, 3, 4});
        assertEquals(0, num2);

        int num3 = problemSet1.findUnsortedSubarray(new int[]{1, 3, 2, 4});
        assertEquals(2, num3);

        int num4 = problemSet1.findUnsortedSubarray(new int[]{5, 4, 3, 2, 1});
        assertEquals(5, num4);

        int num5 = problemSet1.findUnsortedSubarray(new int[]{1, 2, 3, 3, 3});
        assertEquals(0, num5);
    }
}