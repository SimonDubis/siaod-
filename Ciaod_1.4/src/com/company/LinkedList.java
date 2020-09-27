package com.company;

public class LinkedList {

    private Node head = null;
    private Node last = null;

    void add(String number) {
        if(head == null) {
            head = new Node(number);
            last = head;
        } else {
            Node temp = new Node(number);
            last.next = temp;
            temp.previous = last;
            last = temp;
        }
    }

    String searchNumber() {
        Node current = last;
        String number = "";
        do {
            if(current.number.length() == 7) {
                number = current.number;
                deleteNode(current);
                break;
            }
        } while((current = current.previous) != null);
        return number;
    }

    void deleteNode(Node node) {
        if(node == last) {
            last = last.previous;
            last.next = null;
        } else if(node == head) {
            head = head.next;
            head.previous = null;
        } else {
            Node next = node.next;
            Node previous = node.previous;
            next.previous = previous;
            previous.next = next;
        }
    }

    public class Node {
        Node next;
        Node previous;
        String number;

        Node(String number) {
            this.number = number;
            next = null;
            previous = null;
        }
    }
}
