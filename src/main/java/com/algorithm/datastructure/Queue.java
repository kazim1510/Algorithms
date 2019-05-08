package com.algorithm.datastructure;

public class Queue {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public Queue() {
    }

    public void add(int val) {
        Node newNode = new Node(val);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = tail;
        }
    }

    public int remove() {
        int val = head.val;
        head = head.next;
        if (head == null) {
            throw new RuntimeException("");
        }
        return val;
    }
}
