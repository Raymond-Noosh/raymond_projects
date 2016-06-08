package com.raymond.tree;

import java.util.Stack;

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
        Stack s = new Stack();
        if (node != null) {
            s.add(node.left);
            while (!s.isEmpty()) {
                s.peek();
            }
        }
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

    void inorder() {
        if (root == null) {
            return;
        }

        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        Node node = root;

        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    /*
    Inorder Traversal
    In this traversal method, the left left-subtree is visited first, then root and then the right sub-tree.
     */
    public void inOrderPrint() {
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    /*
    Preorder
    In this traversal method, the root node is visited first, then left subtree and finally right sub-tree.
    */
    public void preOrderPrint() {
        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    /**
     Postorder Traversal
     In this traversal method, the root node is visited last, hence the name. First we traverse left subtree, then right subtree and finally root.
     */
    public void postOrderPrint() {
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.data);
        }
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

        Node d = raymondBinaryTree.find(6);
        //Node a = raymondBinaryTree.findWhile(6);

        raymondBinaryTree.inOrderPrint();
        System.out.println("-----------");
        //raymondBinaryTree.preOrderPrint();
        //System.out.println("-----------");
        //raymondBinaryTree.postOrderPrint();
        //System.out.println("-----------");
        raymondBinaryTree.inorder();
    }
}
