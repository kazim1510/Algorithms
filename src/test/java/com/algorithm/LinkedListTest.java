package com.algorithm;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.algorithm.datastructure.LinkedList;

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
    public void clear() throws Exception {
    }

}
