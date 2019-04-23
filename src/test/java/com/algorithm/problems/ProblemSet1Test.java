package com.algorithm.problems;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

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

}
