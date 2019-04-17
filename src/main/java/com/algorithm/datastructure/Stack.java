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
}
