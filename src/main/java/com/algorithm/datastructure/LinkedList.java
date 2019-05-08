package com.algorithm.datastructure;

public class LinkedList {
    public static class Node {
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

    public Node getHead() {
        return head;
    }

    public Node newNode(int val) {
        return new Node(val);
    }

    //problem-1 : Find nth node from the end of a Linked List.
    public int getNthNode(Node head, int n) {
        Node current = head;
        int count = 1;
        while (current != null && count != n) {
            count++;
            current = current.next;
        }

        if (current == null) {
            return 0;
        }
        return current.val;
    }

    //problem-2 : Check whether the given linked list is either NULL-terminated or ends in a cycle
    public boolean loopExists(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    //problem-3 Insert a node in a sorted linked list
    public Node insertInSortedList(Node node) {

        if (head != null && head.val > node.val) {
            node.next = head;
            head = node;
        }

        Node current = head;
        while (current.next != null && current.next.val < node.val) {
            current = current.next;
        }

        Node temp = current.next;
        current.next = node;
        node.next = temp;

        return head;
    }

    // problem-4 Reverse a singly linked list
    public Node reverseLinkedList() {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    // problem-5 two singly linked lists both of which intersect at some point
    // and become a single linked list
    public Node findIntersectingNode(Node node1, Node node2) {

        int node1Length = 0;
        int node2Length = 0;

        Node temp = node1;
        while (temp != null) {
            temp = temp.next;
            node1Length++;
        }

        temp = node2;
        while (temp != null) {
            temp = temp.next;
            node2Length++;
        }


        if (node1Length > node2Length) {
            int tempLength = node1Length - node2Length;
            while (tempLength-- > 0) {
                node1 = node1.next;
            }
        } else {
            int tempLength = node2Length - node1Length;
            while (tempLength-- > 0) {
                node2 = node2.next;
            }
        }

        while (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                return node1;
            }

            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    // problem-6 How will you find the middle of the linked list?
    public Node findMiddleNode(Node node) {
        Node fast = node;
        Node slow = node;
        int i = 0;
        while (fast.next != null) {
            if (i == 0) {
                fast = fast.next;
                i = 1;
            } else if (i == 1) {
                fast = fast.next;
                slow = slow.next;
                i = 0;
            }
        }

        return slow;
    }

    // problem-7 Given two sorted Linked Lists, we need to merge them into the third list in
    // sorted order.
    public Node mergeTwoLists(Node n1, Node n2) {
        Node retrunNode = new Node(0);
        Node curr = retrunNode;

        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                curr.next = n1.next;
                n1 = n1.next;
            } else {
                curr.next = n2.next;
                n2 = n2.next;
            }
        }

        if (n1 != null) {
            curr.next = n1;
        } else if (n2 != null) {
            curr.next = n2;
        }

        return retrunNode.next;
    }

    // problem-8 How will you check if the linked list is palindrome or not?
    public boolean isListPalindrom(Node node) {

        // get the middle of list
        Node fast = node, slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node temp = node;
        Node firstHalf = temp;


        while (temp != slow) {
            temp = temp.next;
        }
        temp.next = null;
        firstHalf = temp;

        // reverse the second half
        Node curr = node;
        Node prev = null;

        while (curr != null) {
            Node temp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp1;
        }
        Node rev = prev;

        // compare it with first half
        while (firstHalf != null && rev != null) {
            if (firstHalf.val != rev.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            rev = rev.next;
        }
        return true;
    }

    // problem-9 Given a list, rotate the list to the right by k places, where k is non-negative. For
    // example: Given 1_->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL
    public Node rotateRight(Node node, int k) {
        int len = 0;

        Node temp = node;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int diff = len - k;

        Node firstPart = node;
        temp = firstPart.next;
        Node secondPart = null;

        while (diff-- > 0) {
            temp = temp.next;
        }

        secondPart = firstPart.next;
        firstPart.next = null;

        temp = secondPart;

        while (k-- > 0) {
            temp = temp.next;
        }

        temp.next = firstPart;

        return secondPart;

    }
}