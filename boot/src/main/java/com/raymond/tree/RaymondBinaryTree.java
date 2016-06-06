package com.raymond.tree;

/**
 * Created by Raymond Kwong on 6/5/2016.
 */
public class RaymondBinaryTree {

    private Node root;

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public RaymondBinaryTree() {
        this.root = null;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        }
        else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void printIt() {
        printTree(root, root.data);
    }

    private Node printTree(Node node, int data) {
        if (node == null) {

        }
        if (data < node.data) {
            node.left = printTree(node.left, data);
        }
        else {
            node.right = printTree(node.right, data);
        }
        return node;
    }

    public static void main (String args[]) {
        RaymondBinaryTree raymondBinaryTree = new RaymondBinaryTree();
        raymondBinaryTree.insert(5);
        raymondBinaryTree.insert(7);
        raymondBinaryTree.insert(4);
        raymondBinaryTree.insert(9);
        raymondBinaryTree.insert(3);
        raymondBinaryTree.insert(6);
        raymondBinaryTree.insert(10);
    }
}
