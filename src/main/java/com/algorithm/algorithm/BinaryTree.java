package com.algorithm.algorithm;

public class BinaryTree {

    public static class Node {
        public int key;
        public String val;
        public Node left;
        public Node right;

        public Node(int key, String val) {
            this.key = key;
            this.val = val;
        }

        public Node min() {
            if (left == null) {
                return left;
            } else {
                return left.min();
            }
        }
    }

    private Node root;

    public BinaryTree() {
    }

    public void insert(int key, String value) {
        root = insertItem(root, key, value);
    }

    private Node insertItem(Node node, int key, String val) {
        Node newNode = new Node(key, val);
        if (node == null) {
            node = newNode;
            return node;
        }

        if (key < node.key) {
            node.left = insertItem(node.left, key, val);
        } else if (key > node.key) {
            node.right = insertItem(node.right, key, val);
        }
        return node;
    }

    public void add(Node parent, Node current, String orientation) {
        if ("left".equals(orientation)) {
            parent.left = current;
        } else {
            parent.right = current;
        }
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    public Node deleteNode(Node node, int key) {
        if (node == null) {
            return null;
        } else if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            // case 1: no child
            if (node.left == null && node.right == null) {
                node = null;
                // case 2: one chid
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                Node minRight = findMin(node.right);
                // case 3: two children

                node.key = minRight.key;
                node.val = minRight.val;

                node.right = deleteNode(node.right, node.key);
            }
        }
        return node;
    }

    public String find(int key) {
        Node node = find(root, key);
        return node.val;
    }

    public Node find(Node node, int key) {
        if (root == null || node.key == key) {
            return node;
        } else if (key < node.key) {
            return find(node.left, key);
        } else if (key > node.key) {
            return find(node.right, key);
        }
        return null;
    }

    public Node findMin(Node node) {
        return node.min();
    }

    public Node getRoot() {
        return root;
    }
}
