package com.algorithm.datastructure;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void SetUp() {
        linkedList = new LinkedList();
    }

    @Test
    public void addFront() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);

        assertEquals(2, linkedList.size());
    }

    @Test
    public void getFirst() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);

        assertEquals(2, linkedList.getFirst());

    }

    @Test
    public void getLast() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);

        assertEquals(2, linkedList.getFirst());
    }

    @Test
    public void addBack() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(4);

        assertEquals(4, linkedList.getLast());
    }

    @Test
    public void deleteNode() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(4);

        linkedList.deleteNode(2);

        assertEquals(2, linkedList.size());
    }

    @Test
    public void nthNode() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(4);

        assertEquals(4, linkedList.getNthNode(linkedList.getHead(), 3));
    }

    @Test
    public void loopExists() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(4);
        linkedList.addBack(5);

        assertEquals(false, linkedList.loopExists(linkedList.getHead()));
    }

    @Test
    public void insertInSortedList() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(5);
        linkedList.addBack(6);
        linkedList.insertInSortedList(linkedList.newNode(1));
        assertEquals(1, linkedList.getNthNode(linkedList.getHead(), 1));
    }

    @Test
    public void reverse() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(5);
        linkedList.addBack(6);
        assertEquals(2, linkedList.getFirst());
        assertEquals(6, linkedList.getLast());
        LinkedList.Node node = linkedList.reverseLinkedList();
        assertEquals(6, linkedList.getNthNode(node, 1));
        assertEquals(3, linkedList.getNthNode(node, 3));
    }

    @Test
    public void intersect() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addBack(5);
        linkedList.addBack(6);

        LinkedList linkedList2 = new LinkedList();

        linkedList2.addFront(3);
        linkedList2.addFront(2);
        linkedList2.addFront(1);
        linkedList2.addBack(5);
        linkedList2.addBack(6);

        LinkedList.Node node = linkedList.findIntersectingNode(linkedList.getHead(), linkedList2.getHead());
        assertEquals(2, node.val);
    }


    @Test
    public void middleNode() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addFront(1);
        linkedList.addBack(5);
        linkedList.addBack(6);
        LinkedList.Node node = linkedList.findMiddleNode(linkedList.getHead());
        assertEquals(3, node.val);
    }

    @Test
    public void palindrome() throws Exception {
        linkedList.addFront(3);
        linkedList.addFront(2);
        linkedList.addFront(1);
        linkedList.addBack(5);
        linkedList.addBack(6);

        LinkedList.Node node = linkedList.rotateRight(linkedList.getHead(), 2);
//        assertEquals(true, success);
    }

    @Test
    public void clear() throws Exception {
    }

}
