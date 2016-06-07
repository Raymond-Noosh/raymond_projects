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

    public Node find(int n) {
        return find(this.root, n);
    }

    private Node find(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            return find(node.left, data);
        }
        else if (data > node.data) {
            return find(node.right, data);
        }
        else {
            return node;
        }
    }

    public Node findWhile(int data) {
        return findWhile(this.root, data);
    }

    private Node findWhile(Node node, int data) {
        if (node == null) {
            return null;
        }
        
        while (data < node.data) {
            node = node.left;
        }
        while (data > node.data) {
            node = node.right;
        }

        return node;
    }

    public void printIt() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    /*private void postOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }*/

    public static void main (String args[]) {
        RaymondBinaryTree raymondBinaryTree = new RaymondBinaryTree();
        raymondBinaryTree.insert(5);
        raymondBinaryTree.insert(7);
        raymondBinaryTree.insert(4);
        raymondBinaryTree.insert(9);
        raymondBinaryTree.insert(3);
        raymondBinaryTree.insert(6);
        raymondBinaryTree.insert(10);

        Node d = raymondBinaryTree.find(6);

        Node a = raymondBinaryTree.findWhile(6);
        System.out.println("test");
        raymondBinaryTree.printIt();
    }
}
