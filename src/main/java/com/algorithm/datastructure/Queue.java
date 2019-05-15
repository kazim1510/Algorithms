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

        if (head != null) {
            head = head.next;
        }
        return val;
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        Queue.Node current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
