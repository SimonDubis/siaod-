package com.company;

public class List<T extends Comparable<T>> {

    private Node head = null;
    private Node last = null;

    void add(String number) {
        if(head == null) {
            head = new Node(number);
            last = head;
        } else {
            Node temp = new Node(number);
            if(temp.compareTo(head) <= 0) {
                temp.next = head;
                head = temp;
            } else if(head == last){
                head.next = temp;
                last = temp;
            } else {
                putElement(temp);
            }
        }
    }

    void putElement (Node node) {
        Node currentPrevious = head;
        Node current = head.next;
        do {
            if (node.compareTo(current) <= 0) {
                currentPrevious.next = node;
                node.next = current;
                break;
            } else if(current == last) {
                current.next = node;
                last = node;
                break;
            }
            currentPrevious = current;
        } while((current = current.next) != null);
    }

    void show() {
        Node current = head;
        do {
            System.out.printf("%8s\n", current.number);
        } while((current = current.next) != null);
    }

    public class Node implements Comparable<Node> {
        Node next;
        String number;

        Node(String number) {
            this.number = number;
            next = null;
        }

        @Override
        public int compareTo(Node node) {
            return number.compareTo(node.number);
        }

    }
}