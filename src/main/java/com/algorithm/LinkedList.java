package com.algorithm;

public class LinkedList {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;

    public LinkedList() {
    }

    public void addFront(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        this.head = newNode;
    }

    public int getFirst() {
        return head.val;
    }

    public int getLast() {
        return getLastNode().val;
    }

    public Node getLastNode() {
        if (head == null) {
            throw new RuntimeException("");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public void addBack(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            this.head = newNode;
            return;
        }
        Node lastNode = getLastNode();
        lastNode.next = newNode;
    }

    public void deleteNode(int val) {
        if (head == null) {
            return;
        }

        if (head.val == val) {
            this.head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        Node current = head;
        int count = 1;
        while (current.next != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    public void clear() {
        head = null;
    }
}