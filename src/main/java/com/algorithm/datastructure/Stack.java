package com.algorithm.datastructure;

public class Stack {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    public Stack() {

    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            throw new RuntimeException("");
        }

        Node returnNode = head;
        head = head.next;
        return returnNode.val;
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        Stack.Node current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // problem-1 evaluate expression
    public int evaluateExpression(String[] tokens) {
        Stack stack = new Stack();
        for (String str : tokens) {
            if (str.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int res = val2 + val1;
                stack.push(res);
            } else if (str.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int res = val2 - val1;
                stack.push(res);
            } else if (str.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int res = val2 * val1;
                stack.push(res);
            } else if (str.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                int res = val2 / val1;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }

    // problem-2 how to reverse the contents of the stack using only stack
    // operations (push and pop)?

    public void reverseStack(Stack stack) {
        if (head == null) {
            return;
        }
        int temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
    }

    private void insertAtBottom(Stack stack, int val) {
        if (head == null) {
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, val);
        stack.push(temp);
    }
}
