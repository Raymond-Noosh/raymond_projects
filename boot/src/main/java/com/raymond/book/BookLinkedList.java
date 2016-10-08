package com.raymond.book;

import com.raymond.array.RaymondLinkedList;

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
    public int getKthFromLast(RaymondLinkedList linkedList, int k) {
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

    public void partition(RaymondLinkedList numbers, Integer partition) {
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

    public RaymondLinkedList.Node parting(RaymondLinkedList.Node node, Integer x) {
        RaymondLinkedList.Node head = node;
        RaymondLinkedList.Node tail = node;

        while (node != null) {
            RaymondLinkedList.Node next = node.getNext();
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

    public RaymondLinkedList sumList(RaymondLinkedList a, RaymondLinkedList b) {
        RaymondLinkedList sum = new RaymondLinkedList();
        RaymondLinkedList.Node cursor1 = a.getHead();
        RaymondLinkedList.Node cursor2 = b.getHead();
        while (cursor1 != null && cursor2 != null) {
            RaymondLinkedList.Node next1 = cursor1.getNext();
            RaymondLinkedList.Node next2 = cursor2.getNext();

            Integer temp = cursor1.getData() + cursor2.getData();
            sum.insertToEnd(temp);

            if (next1 == null && next2 != null) {
                a.insertToEnd(0);
                next1 = cursor1.getNext();
            }
            if (next2 == null && next1 != null) {
                b.insertToEnd(0);
                next2 = cursor2.getNext();
            }
            cursor1 = next1;
            cursor2 = next2;
        }

        RaymondLinkedList.Node head = sum.getHead();
        while (head != null) {
            RaymondLinkedList.Node next = head.getNext();
            Integer v = head.getData();
            if (v.intValue() > 10) {
                int digit = v.intValue() % 10;
                head.setData(digit);
                if (next != null) {
                    next.setData(next.getData() + 1);
                }
                else {
                    sum.insertToEnd(1);
                }
            }
            head = next;
        }
        return sum;
    }

    public RaymondLinkedList sumListFoward(RaymondLinkedList a, RaymondLinkedList b) {
        RaymondLinkedList sum = new RaymondLinkedList();
        RaymondLinkedList.Node cursor1 = a.getHead();
        RaymondLinkedList.Node cursor2 = b.getHead();
        while (cursor1 != null && cursor2 != null) {
            RaymondLinkedList.Node next1 = cursor1.getNext();
            RaymondLinkedList.Node next2 = cursor2.getNext();

            Integer temp = cursor1.getData() + cursor2.getData();
            sum.insertToEnd(temp);

            if (next1 == null && next2 != null) {
                a.insertToEnd(0);
                next1 = cursor1.getNext();
            }
            if (next2 == null && next1 != null) {
                b.insertToEnd(0);
                next2 = cursor2.getNext();
            }
            cursor1 = next1;
            cursor2 = next2;
        }

        /*RaymondLinkedList<Integer>.Node node = sum.getHead();
        RaymondLinkedList<Integer>.Node head = sum.getHead();
        while (node != null) {
            RaymondLinkedList<Integer>.Node next = node.getNext();
            if (head.getData() > 9 && head.equals(node)) {
                Integer v = head.getData();
                int digit = v.intValue() % 10;
                head.setData(digit);
                sum.insertToFront(1);
                head = sum.getHead();
            }
            if (next != null) {
                Integer v = next.getData();
                if (v > 9) {
                    int digit = v.intValue() % 10;
                    next.setData(digit);
                    node.setData(node.getData() + 1);
                    node = head;
                }
                else {
                    node = next;
                }
            }
            else {
                node = next;
            }
        }*/
        return sum;
    }

    public RaymondLinkedList.Node sumListBackward(RaymondLinkedList a, RaymondLinkedList b, Integer carry) {
        return sumListBackward(a.getHead(), b.getHead(), 0);
    }

    public RaymondLinkedList.Node sumListBackward(RaymondLinkedList.Node a, RaymondLinkedList.Node b, Integer carry) {
        Integer value = carry;
        if (a != null) {
            value = value + a.getData();
        }
        if (b != null) {
            value = value + b.getData();
        }

        RaymondLinkedList.Node node = new RaymondLinkedList.Node(value % 10);
        if ((a != null || b != null)) {
            RaymondLinkedList.Node next = sumListBackward(a.getNext(), b.getNext(), (value > 9 ? 1 : 0));
            node.setNext(next);
        }
        return node;
    }

    public static class BookNode {
        RaymondLinkedList.Node node;
        int carry;

        public RaymondLinkedList.Node getNode() {
            return node;
        }

        public void setNode(RaymondLinkedList.Node node) {
            this.node = node;
        }

        public int getCarry() {
            return carry;
        }

        public void setCarry(int carry) {
            this.carry = carry;
        }
    }

    public BookNode sumListForward(RaymondLinkedList.Node a, RaymondLinkedList.Node b) {
        if (a == null && b == null) {
            return new BookNode();
        }

        BookNode node = sumListForward(a.getNext(), b.getNext());
        Integer value = node.getCarry() + a.getData() + b.getData();

        int digit = value % 10;
        RaymondLinkedList.Node full = RaymondLinkedList.Node.insertInFront(node.getNode(), digit);

        node.setNode(full);
        node.setCarry(value > 9 ? 1 : 0);

        return node;
    }

    public RaymondLinkedList.Node sumListFowardMain(RaymondLinkedList.Node a, RaymondLinkedList.Node b) {
        //for now assume padding is there

        BookNode ss = sumListForward(a, b);
        if (ss.getCarry() > 0) {
            RaymondLinkedList.Node tt = RaymondLinkedList.Node.insertInFront(ss.getNode(), ss.getCarry());
            ss.setNode(tt);
        }
        return ss.getNode();
    }

    /*public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("abc");
        list.add("ghi");
        list.add("abc");
        list.add("def");
        list.add("def");

        BookLinkedList l = new BookLinkedList();
        l.removeDuplicate(list);

        System.out.println(list);


        //RaymondLinkedList linkedList = new RaymondLinkedList<>();
        //linkedList.insertToEnd("a");
        //linkedList.insertToEnd("b");
        //linkedList.insertToEnd("c");
        //linkedList.insertToEnd("d");
        //linkedList.insertToEnd("e");
        //linkedList.insertToEnd("f");
        //l.deleteMiddleNode(linkedList.getNode("c"));
        //linkedList.print();


        RaymondLinkedList integerLinkedList = new RaymondLinkedList();
        integerLinkedList.insertToEnd(new Integer(3));
        integerLinkedList.insertToEnd(new Integer(4));
        integerLinkedList.insertToEnd(new Integer(9));
        //integerLinkedList.insertToEnd(new Integer(5));
        //integerLinkedList.insertToEnd(new Integer(10));
        //integerLinkedList.insertToEnd(new Integer(2));
        //integerLinkedList.insertToEnd(new Integer(1));
        //l.partition(integerLinkedList, new Integer(5));
        //RaymondLinkedList<Integ er>.Node redone = l.parting(integerLinkedList.getHead(), new Integer(5));
        //integerLinkedList.print(redone);

        RaymondLinkedList integerLinkedList2 = new RaymondLinkedList();
        integerLinkedList2.insertToEnd(new Integer(7));
        integerLinkedList2.insertToEnd(new Integer(5));
        integerLinkedList2.insertToEnd(new Integer(4));
        RaymondLinkedList.Node result = l.sumListFowardMain(integerLinkedList.getHead(), integerLinkedList2.getHead());
        integerLinkedList.print(result);
    }*/
}
