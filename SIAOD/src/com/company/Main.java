package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    static List list1 = new List();
    static List list2 = new List();
    static List resultList = new List();

    public static void main(String[] args) throws IOException {
        readFile();
        workMethod();
    }

    static void workMethod() {
        if(list1.isEmpty() || list2.isEmpty()) {
            System.out.println("Lists are empty");
            return;
        }
        mainInstructions();
        int command;
        while((command = inputCommand(userInput())) != 0) {
            switch (command) {
                case 1 :
                    compareLists();
                    break;
                case 2 :
                    calculateList();
                    break;
                case 3 :
                    combineList();
                    break;
                case 4 :
                    getList();
                    break;
            }
            mainInstructions();
        }
    }

    static void combineList() {
        resultList = List.add(list1, list2);
        resultList.show();
    }

    static void getList() {
        System.out.println("Enter number of list");
        if(Integer.parseInt(userInput()) == 1) {
            list1.show();
        } else {
            list2.show();
        }
    }

    static void compareLists() {
        if (List.equality(list1, list2)) {
            System.out.println("Lists are equal.");
        } else {
            System.out.println("Lists aren`t equal.");
        }
    }

    static void calculateList() {
        System.out.println("Enter number of list");
        int sum = 0;
        if(Integer.parseInt(userInput()) == 1) {
            sum = calculate(list1);
        } else {
            sum = calculate(list2);
        }
        System.out.println("Result : " + sum);
    }

    static int calculate(List list) {
        System.out.println("Enter value of X : ");
        int x = Integer.parseInt(userInput());
        return List.meaning(list, x);
    }

    static void readFile() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Asus/IdeaProjects/SIAOD/src/com/company/data.txt"));
        fillList(list1, bf.readLine());
        fillList(list2, bf.readLine());
        bf.close();
    }

    static void fillList(List list, String line) {
        String[] elements = line.split("\\s+");
        for(int i = 0; i < elements.length; i++) {
            list.add(Integer.parseInt(elements[i]));
        }
    }

    static void mainInstructions() {
        System.out.println("Enter 1, if you want to compare two lists.");
        System.out.println("Enter 2, if you want to calculate list.");
        System.out.println("Enter 3, if you want to combine two lists.");
        System.out.println("Enter 4, if you want to see two lists.");
        System.out.println("Enter 0, if you want out.");
    }

    static int inputCommand(String input) {
        int number = Integer.parseInt(input);
        if(number < 0 || number > 4) {
            System.out.println("Invalid command, try again.");
            return inputCommand(userInput());
        }
        return number;
    }

    static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
