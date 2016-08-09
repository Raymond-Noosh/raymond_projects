package com.raymond.array;

/**
 * Created by Raymond Kwong on 6/23/2016.
 */
public class RaymondLinkedList<T> {
    public class Node {
        T data;
        Node next = null;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head;
    private int size = 0;

    public RaymondLinkedList() {

    }

    public Node getHead() {
        return head;
    }

    public void insert(T data) {
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

    public void delete(T data) {
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

    public Node getNode(T data) {
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

    public T getKthFromLast(int k) {
        int size = getSize();
        int count = 1;
        Node temp = head;
        while (count < (size-k)) {
            temp = temp.next;
            count++;
        }
        return temp.getData();
    }

    public static void main(String[] args) {
        RaymondLinkedList<String> linkedList = new RaymondLinkedList<>();
        linkedList.insert("1");
        linkedList.insert("2");
        linkedList.insert("3");
        linkedList.delete("4");
        linkedList.insert("5");
        linkedList.insert("6");
        //System.out.println(linkedList.getNode("def").data);
        //linkedList.print();
        //System.out.println(linkedList.getSize());
        System.out.println(linkedList.getKthFromLast(0));
    }


}
