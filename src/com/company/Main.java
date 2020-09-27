package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static List list = new List();

    public static void main(String[] args) throws IOException {
        fillList();
        workMethod();
    }

    static void workMethod() {
        mainInstructions();
        int input;
        while((input = Integer.parseInt(userInput())) != 0) {
            switch (input) {
                case 1:
                    System.out.println("Enter a last name.");
                    String name = userInput();
                    String[] line = list.searchNumber(name);
                    if(line.length == 0) {
                        System.out.println("No matches.");
                    } else {
                        System.out.println(Arrays.toString(line));
                    }
                    break;
                case 2:
                    System.out.println("Enter a number.");
                    System.out.println(list.searchLastName(userInput()));
                    break;
                case 3:
                    list.show();
                    break;
            }
            mainInstructions();
        }
    }

    static void mainInstructions() {
        System.out.println("Enter 1, if you want to find a number by last name.");
        System.out.println("Enter 2, if you want to find a last name by number.");
        System.out.println("Enter 3, if you want to see list.");
        System.out.println("Enter 0, if you want out.");
    }

    static void fillList() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Asus/IdeaProjects/Ciaod_1.3/src/com/company/data.txt"));
        String line;
        String[] arr;
        while((line = bf.readLine()) != null) {
            arr = line.split("\\s+");
            list.add(arr[0], arr[1]);
        }
    }

    static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}