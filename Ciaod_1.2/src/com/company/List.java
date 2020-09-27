package com.company;

public class List {

    private Node head = null;
    private Node last = null;
    private int lastIndex = 1;

    void add(int index) {
        if(head == null) {
            head = new Node(lastIndex);
            last = head;
            last.next = head;
        } else {
            last.next = new Node(++lastIndex);
            last = last.next;
        }
    }

    int delete(int range) {
        Node current = last;
        int i = 0;
        while(current.next != current) {
            if(i == range - 1) {
                current.next = current.next.next;
                i = 0;
            } else {
                i++;
                current = current.next;
            }
        }
        return current.index;
    }

    public class Node {
        Node next;
        int index;
        Node(int index) {
            this.index = index;
            next = head;
        }
    }
}