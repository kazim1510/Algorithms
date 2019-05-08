package com.algorithm.datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {
    private Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack();
    }

    @Test
    public void evaluateExpression() throws Exception {
        int val = stack.evaluateExpression(new String[]{"1", "2", "3", "*", "+", "5", "-"});
        assertEquals(2, val);
    }

    @Test
    public void reverseStack() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.reverseStack(stack);
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());

    }
}
