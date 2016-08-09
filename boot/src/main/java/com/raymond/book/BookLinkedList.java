package com.raymond.book;

import com.raymond.array.RaymondLinkedList;
import org.omg.CORBA.INTERNAL;

import java.util.*;

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
    //This only works if size is known
    public int getKthFromLast(RaymondLinkedList<Integer> linkedList, int k) {
        return linkedList.getKthFromLast(k);
    }


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

    public void partition(RaymondLinkedList<Integer> numbers, Integer partition) {
        RaymondLinkedList.Node head = numbers.getHead();
        RaymondLinkedList.Node cursor = head;
        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        }
        RaymondLinkedList.Node end = cursor;

        RaymondLinkedList.Node previous = head;
        cursor = head;
        while (cursor.getNext() != null) {
            Integer data = (Integer) cursor.getData();
            if (data.intValue() < partition.intValue()) { //move to start
                previous.setNext(cursor.getNext());
                head = cursor;
                head.setNext(cursor.getNext());
            }
            else { //move to end
                previous.setNext(cursor.getNext());
                end.setNext(cursor);
                end = cursor;
            }
            cursor = cursor.getNext();
        }
    }

    public RaymondLinkedList<Integer>.Node parting(RaymondLinkedList<Integer>.Node node, Integer x) {
        RaymondLinkedList<Integer>.Node head = node;
        RaymondLinkedList<Integer>.Node tail = node;

        while (node != null) {
            RaymondLinkedList<Integer>.Node next = node.getNext();
            if (node.getData() < x) {
                node.setNext(head);
                head = node;
            }
            else {
                tail.setNext(node);
                tail = node;
            }
            node = next;
        }
        tail.setNext(null);

        return head;
    }

    public RaymondLinkedList<Integer> sumList(RaymondLinkedList<Integer> a, RaymondLinkedList<Integer> b) {
        RaymondLinkedList<Integer> sum = new RaymondLinkedList<>();
        RaymondLinkedList<Integer>.Node cursor1 = a.getHead();
        RaymondLinkedList<Integer>.Node cursor2 = b.getHead();
        while (cursor1 != null && cursor2 != null) {
            RaymondLinkedList<Integer>.Node next1 = cursor1.getNext();
            RaymondLinkedList<Integer>.Node next2 = cursor2.getNext();

            Integer temp = cursor1.getData() + cursor2.getData();
            sum.insert(temp);

            if (next1 == null && next2 != null) {
                a.insert(0);
                next1 = cursor1.getNext();
            }
            if (next2 == null && next1 != null) {
                b.insert(0);
                next2 = cursor2.getNext();
            }
            cursor1 = next1;
            cursor2 = next2;
        }

        RaymondLinkedList<Integer>.Node head = sum.getHead();
        while (head != null) {
            RaymondLinkedList<Integer>.Node next = head.getNext();
            Integer v = head.getData();
            if (v.intValue() > 10) {
                int digit = v.intValue() % 10;
                head.setData(digit);
                if (next != null) {
                    next.setData(next.getData() + 1);
                }
                else {
                    sum.insert(1);
                }
            }
            head = next;
        }
        return sum;
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
        //linkedList.print();


        RaymondLinkedList<Integer> integerLinkedList = new RaymondLinkedList<>();
        integerLinkedList.insert(new Integer(9));
        integerLinkedList.insert(new Integer(7));
        //integerLinkedList.insert(new Integer(8));
        //integerLinkedList.insert(new Integer(5));
        //integerLinkedList.insert(new Integer(10));
        //integerLinkedList.insert(new Integer(2));
        //integerLinkedList.insert(new Integer(1));
        //l.partition(integerLinkedList, new Integer(5));
        //RaymondLinkedList<Integer>.Node redone = l.parting(integerLinkedList.getHead(), new Integer(5));
        //integerLinkedList.print(redone);

        RaymondLinkedList<Integer> integerLinkedList2 = new RaymondLinkedList<>();
        integerLinkedList2.insert(new Integer(6));
        integerLinkedList2.insert(new Integer(8));
        integerLinkedList2.insert(new Integer(5));
        RaymondLinkedList<Integer> sum = l.sumList(integerLinkedList, integerLinkedList2);
        sum.print();
    }
}
