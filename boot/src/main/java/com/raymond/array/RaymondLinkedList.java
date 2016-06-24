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

    public RaymondLinkedList() {

    }

    public void insert(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void delete(T data) {
        if (head.data == null) {
            return;
        }
        else if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
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

    public static void main(String[] args) {
        RaymondLinkedList<String> linkedList = new RaymondLinkedList<>();
        linkedList.insert("abc");
        linkedList.insert("def");
        linkedList.insert("ghi");
        linkedList.delete("ghi");
        System.out.println(linkedList.getNode("def").data);
        linkedList.print();
    }


}
