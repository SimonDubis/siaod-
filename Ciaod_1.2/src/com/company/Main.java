package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int elem = 3;
        System.out.println("elements\trange\tlast element");
        for(int i = 1; i < 65; i++) {
            List list = new List();
            fillList(i, list);
            System.out.printf("%3d\t%12d\t\t%4d\n", i, elem, list.delete(elem));
        }
    }

    static List fillList(int count, List list) {
        for(int i = 1; i < count + 1; i++) {
            list.add(i);
        }
        return list;
    }
}