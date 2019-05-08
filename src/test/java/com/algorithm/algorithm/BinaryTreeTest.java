package com.algorithm.algorithm;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    private BinaryTree binaryTree;

    @Before
    public void setUp() throws Exception {
        binaryTree = new BinaryTree();
    }

    @Test
    public void insert() throws Exception {
        binaryTree.insert(5,"5");
        binaryTree.insert(3,"3");
        binaryTree.insert(2,"2");
        binaryTree.insert(4,"4");
        binaryTree.insert(7,"7");
        binaryTree.insert(6,"6");
        binaryTree.insert(8,"8");

        assertEquals("5", binaryTree.find(5));
    }

    @Test
    public void find() throws Exception {
    }

}
