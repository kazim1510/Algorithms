package com.algorithm.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemSet1 {

    /**
     * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.
     * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
     * Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
     * Example 1:
     * Input: R = 1, C = 2, r0 = 0, c0 = 0
     * Output: [[0,0],[0,1]]
     * Explanation: The distances from (r0, c0) to other cells are: [0,1]
     * Example 2:
     * Input: R = 2, C = 2, r0 = 0, c0 = 1
     * Output: [[0,1],[0,0],[1,1],[1,0]]
     * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
     * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
     * Example 3:
     * Input: R = 2, C = 3, r0 = 1, c0 = 2
     * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
     * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int b = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return Integer.compare(a, b);
        });

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] n = new int[]{i, j};
                queue.offer(n);
            }
        }

        int length = R * C;
        int[][] result = new int[length][2];
        int i = 0;
        while (i < length) {
            result[i++] = queue.poll();
        }
        return result;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * <p>
     * Note:
     * You must do this in-place without making a copy of the array.
     * Minimize the total number of operations.
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] == 0 && nums[i] != 0) {
                swap(nums, k, i);
                k++;
            } else if (nums[k] != 0) {
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
     * <p>
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
     * Otherwise, the NOT null node will be used as the node of new tree.
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * <p>
     * You may assume that the array is non-empty and the majority element always exist in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     * <p>
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public int[] numMovesStones(int a, int b, int c) {
        int ab = Math.abs(a - b);
        int bc = Math.abs(b - c);
        int ca = Math.abs(c - a);

        int max = Math.max(ab, Math.max(bc, ca));
        int min = Math.min(ab, Math.min(bc, ca));

        int[] result = new int[2];
        result[0] = 2;
        if (min == 1) {
            if (max == 2) {
                result[0] = 0;
            } else {
                result[0] = 1;
            }
        } else if (min == 2) {
            result[0] = 1;
        }

        result[1] = max - 2;

        return result;
    }

    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (start == -1) {
                    start = i;
                }
                end = i + 2;
            }
        }

        if (start < 0) {
            return 0;
        }

        return end - start;
    }

    /**
     * Complete the function that takes an integer as its argument and returns the encoded string in base 7 using the following encoding rule:
     * base 10 - 0 1 2 3 4 5 6
     * base 7  - 0 a t l s i n
     * Sample Input 1 7 Sample Output 1 a0
     */
    public String getBase7(int val) {
        char[] arr = new char[]{'0', 'a', 't', 'l', 's', 'i', 'n'};
        if (val == 0) {
            return "0";
        }

        StringBuilder str = new StringBuilder();
        while (val > 0) {
            int temp = val % 7;
            str.append(arr[temp]);
            val = val / 7;
        }

        return str.reverse().toString();
    }

}
