package com.raymond.book;

import com.raymond.array.RaymondLinkedList;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Raymond Kwong on 6/23/2016.
 */
public class BookLinkedList<T> {

    //Write code to remove duplicates from an unsorted list
    //Traverse from left to right and check for the value
    public void removeDuplicate(LinkedList<T> list) {
        LinkedList<T> duplicateList = new LinkedList<T>();
        LinkedList<T> tempList = new LinkedList<T>();
        for (T t: list) {
            if (tempList.contains(t)) {
                duplicateList.add(t);
            }
            else {
                tempList.add(t);
            }
        }
        list.removeAll(duplicateList);
    }

    //Using my RaymondLinkedList
    //Implement an alg to find the kth to last element of a singly linked list


    //Using my RaymondLinkedList
    //Implement an alg to delete a node in the middle, any node but the first and last, not necessarily the exact middle, given only access to that node
    //a->b->c->d->e->f
    //input c, result a->b->d->e->f
    public void deleteMiddleNode(RaymondLinkedList.Node node) {
        RaymondLinkedList.Node temp = node;
        if(temp.getNext() != null) {
            temp.setData(temp.getNext().getData());
            temp.setNext(temp.getNext().getNext());
        }
    }




    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("abc");
        list.add("ghi");
        list.add("abc");
        list.add("def");
        list.add("def");

        BookLinkedList l = new BookLinkedList();
        l.removeDuplicate(list);

        System.out.println(list);


        RaymondLinkedList<String> linkedList = new RaymondLinkedList<>();
        linkedList.insert("a");
        linkedList.insert("b");
        linkedList.insert("c");
        linkedList.insert("d");
        linkedList.insert("e");
        linkedList.insert("f");
        l.deleteMiddleNode(linkedList.getNode("c"));
        linkedList.print();

    }
}
