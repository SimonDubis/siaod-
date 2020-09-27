package com.company;

public class List {

    private Node head = null;
    private Node last = null;
    private int lastIndex = 0;

    void add(int rate) {
        if(head == null) {
            head = new Node(rate, lastIndex);
            last = head;
        } else {
            last.next = new Node(rate, ++lastIndex);
            last = last.next;
        }
    }

    static boolean equality(List list1, List list2) {
        boolean isFlag = false;
        if(list1.lastIndex == list2.lastIndex) {
            isFlag = true;
            Node currentList1 = list1.head;
            Node currentList2 = list2.head;
            do {
                if(currentList1.rate != currentList2.rate) {
                    isFlag = false;
                }
            } while (isFlag && (currentList1 = currentList1.next) != null &&
                    (currentList2 = currentList2.next) != null);
        }
        return isFlag;
    }

    boolean isEmpty() {
        return head == null;
    }

    void show() {
        Node current = head;
        do {
            if(current.rate != 0) {
                if(current.next == null) {
                    System.out.printf("%d*x^%d", current.rate, current.index);
                } else {
                    System.out.printf("%d*x^%d + ", current.rate, current.index);
                }
            }
        } while((current = current.next) != null);
        System.out.println("");
    }

    static int meaning (List list, int x) {
        Node current = list.head;
        int sum = 0;
        do {
            sum += current.rate * Math.pow(x, current.index);
        } while((current = current.next) != null);
        return sum;
    }

    static List add(List list1, List list2) {
        List list;
        if(list1.lastIndex >= list2.lastIndex) {
            list = addList(list1, list2);
        } else {
            list = addList(list2, list1);
        }
        return list;
    }

    private static List addList(List list, List additionalList) {
        Node current = list.head, currentAdd = additionalList.head;
        do {
            current.rate += currentAdd.rate;
            current = current.next;
        } while((currentAdd = currentAdd.next) != null);
        return list;
    }

    public class Node {
        Node next;
        int index;
        int rate;
        Node(int rate, int index) {
            this.rate = rate;
            this.index = index;
            next = null;
        }
    }

}
