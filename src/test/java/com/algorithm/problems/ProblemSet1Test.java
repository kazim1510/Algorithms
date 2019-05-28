package com.algorithm.problems;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.algorithm.algorithm.BinaryTree;

import static org.junit.Assert.*;

public class ProblemSet1Test {

    private ProblemSet1 problemSet1;
    private BinaryTree binaryTree;

    @Before
    public void setUp() throws Exception {
        problemSet1 = new ProblemSet1();
        binaryTree = new BinaryTree();
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

    @Test
    public void getBase7() {
        assertEquals("0", problemSet1.getBase7(0));
        assertEquals("a0", problemSet1.getBase7(7));
        assertEquals("ass", problemSet1.getBase7(81));
        assertEquals("tits", problemSet1.getBase7(949));
    }

    @Test
    public void isUnique() {
        assertFalse(problemSet1.isUnique("aa"));
        assertTrue(problemSet1.isUnique("ab"));
        assertFalse(problemSet1.isUnique("abcdafjkoup"));
        assertTrue(problemSet1.isUnique("abcdfjkoup"));
    }

    @Test
    public void urlify() {
        assertEquals("My%20Home%20Page", problemSet1.urlify("My Home Page", 16));
    }

    @Test
    public void oneAway() {
        assertTrue(problemSet1.oneAway("pales", "ples"));
        assertTrue(problemSet1.oneAway("pales", "pales"));
        assertTrue(problemSet1.oneAway("pales", "bales"));
        assertFalse(problemSet1.oneAway("pales", "ble"));
    }

    @Test
    public void compress() {
        Assert.assertEquals("a3b2", problemSet1.compressor("aaabb"));
        Assert.assertEquals("a2b2", problemSet1.compressor("aabb"));
        Assert.assertEquals("ab", problemSet1.compressor("ab"));
        Assert.assertEquals("abc", problemSet1.compressor("abc"));
        Assert.assertEquals("z3", problemSet1.compressor("zzz"));
    }

    @Test
    public void checkSubTree() {
        Assert.assertEquals("a3b2", problemSet1.compressor("aaabb"));
        Assert.assertEquals("a2b2", problemSet1.compressor("aabb"));
        Assert.assertEquals("ab", problemSet1.compressor("ab"));
        Assert.assertEquals("abc", problemSet1.compressor("abc"));
        Assert.assertEquals("z3", problemSet1.compressor("zzz"));
    }

    @Test
    public void countPathWithSum() {
        binaryTree.insert(10, "5");

        BinaryTree.Node node1 = new BinaryTree.Node(5,"5");
        BinaryTree.Node node2 = new BinaryTree.Node(-3, "3");
        BinaryTree.Node node3 = new BinaryTree.Node(3, "3");
        BinaryTree.Node node4 = new BinaryTree.Node(2, "2");
        BinaryTree.Node node5 = new BinaryTree.Node(11, "11");
        BinaryTree.Node node6 = new BinaryTree.Node(3, "3");
        BinaryTree.Node node7 = new BinaryTree.Node(-2, "-2");
        BinaryTree.Node node8 = new BinaryTree.Node(1, "1");

        binaryTree.add(binaryTree.getRoot(), node1, "left");
        binaryTree.add(binaryTree.getRoot(), node2, "right");
        binaryTree.add(node1, node3, "left");
        binaryTree.add(node1, node4, "right");
        binaryTree.add(node2, node5, "right");
        binaryTree.add(node3, node6, "left");
        binaryTree.add(node3, node7, "right");
        binaryTree.add(node4, node8, "right");

        assertEquals(3, problemSet1.countPathWithSum(binaryTree.getRoot(), 8));
    }
}
