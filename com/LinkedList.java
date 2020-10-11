package com;

public class LinkedList {
    Node head;

    public class Node {
        String key;
        String reference;
        Node next;

        Node(String k, String ref) {
            key = k;
            reference = ref;
        }
    }

    void add(String key, String reference) {
        Node new_node = new Node(key, reference);
        if(this.head == null){
            new_node.next = null;
            this.head = new_node;
            return;
        }
        Node currNode = this.head;
        Node prevNode = null;
        while (currNode != null) {
            if(compareStrings(currNode.key, key)){
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if(prevNode == null){
            new_node.next = currNode;
            this.head = new_node;
            return;
        }
        prevNode.next = new_node;
        new_node.next = currNode;
    }

    void print() {
        Node currNode = this.head;
        while (currNode != null) {
            System.out.println(currNode.key + " - " + currNode.reference);
            currNode = currNode.next;
        }
        System.out.println();
    }

    String search(String key) {
        Node currNode = this.head;
        while(((currNode != null))&&(!compareStrings(currNode.key, key))){
            if(currNode.key.equals(key)){
                return currNode.reference;
            }
            currNode = currNode.next;
        }
        return null;
    }

    boolean remove(String key){
        Node currNode = this.head;
        Node prevNode = null;
        while(((currNode != null))&&(!compareStrings(currNode.key, key))){
            if(currNode.key.equals(key)){
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        if((currNode == null)||(compareStrings(key, currNode.key))){
            return false;
        }
        else{
            if(currNode == this.head){
                this.head = currNode.next;
            }
            else{
                prevNode.next = currNode.next;
            }
            return true;
        }
    }

    boolean compareStrings(String str1, String str2){
        int max = Math.max(str1.length(), str2.length());
        for(int i = 0; i < max; i++){
            if(str2.length() == i){
                return true;
            }
            if(str1.length() == i){
                return false;
            }
            if(str1.charAt(i) > str2.charAt(i)){
                return true;
            }
            if(str1.charAt(i) < str2.charAt(i)){
                return false;
            }
        }
        return false;
    }
}