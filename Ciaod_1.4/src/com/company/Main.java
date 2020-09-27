package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    static LinkedList linkedList = new LinkedList();
    static List list = new List();

    public static void main(String[] args) throws IOException {
        fillList();
        createList();
    }

    static void createList() {
        String line;
        LinkedList tempLinkedList = linkedList;
        while(!(line = tempLinkedList.searchNumber()).equals("")) {
            list.add(line);
        }
        list.show();
    }

    static void fillList() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Asus/IdeaProjects/Ciaod_1.4/src/com/company/data.txt"));
        String line;
        while((line = bf.readLine()) != null) {
            linkedList.add(line);
        }
    }
}
