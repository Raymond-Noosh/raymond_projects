package com.raymond.array;

/**
 * Created by Raymond Kwong on 6/23/2016.
 */
public class RaymondLinkedList {
    public static class Node {
        Integer data;
        Node next = null;

        public Node(java.lang.Integer data) {
            this.data = data;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public static Node insertInFront(Node node, Integer value) {
            Node temp = new Node(value);
            temp.setNext(node);
            return temp;
        }
    }
    private Node head;
    private int size = 0;

    public RaymondLinkedList() {

    }

    public Node getHead() {
        return head;
    }

    public void insertToFront(Integer data) {
        if (head == null) {
            head = new Node(data);
            size = 1;
            return;
        }

        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public void insertToEnd(Integer data) {
        if (head == null) {
            head = new Node(data);
            size = 1;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        size++;
    }

    public void delete(Integer data) {
        if (head.data == null) {
            return;
        }
        else if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    public Node getNode(Integer data) {
        if (head.data == data) {
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == data) {
                return temp;
            }
        }
        return null;
    }

    public void print() {
        print(head);
    }

    public void print(Node node) {
        Node temp = node;
        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data+ " ");
    }

    public int getSize() {
        return size;
    }

    public Integer getKthFromLast(int k) {
        int size = getSize();
        int count = 1;
        Node temp = head;
        while (count < (size-k)) {
            temp = temp.next;
            count++;
        }
        return temp.getData();
    }

    /*public static void main(String[] args) {
        RaymondLinkedList linkedList = new RaymondLinkedList();
        linkedList.insertToEnd(1);
        linkedList.insertToEnd(2);
        linkedList.insertToEnd(3);
        linkedList.delete(4);
        linkedList.insertToEnd(5);
        linkedList.insertToEnd(6);
        //System.out.println(linkedList.getNode("def").data);
        //linkedList.print();
        //System.out.println(linkedList.getSize());
        System.out.println(linkedList.getKthFromLast(0));
    }*/


}
