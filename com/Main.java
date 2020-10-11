package com;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dict dict = new Dict();
        dict.fill();
        Scanner scan = new Scanner(System.in);
        boolean escape = false;

        while(!escape){
            System.out.println("\nМеню:\nПоказать словарь - 1\nПоиск - 2\nВставить - 3\n" +
                    "Удалить - 4\nЗавершить работу - 5\n");
            switch (scan.nextInt()){
                case 1:
                    dict.print();
                    break;
                case 2:
                    dict.search();
                    break;
                case 3:
                    dict.add();
                    break;
                case 4:
                    dict.remove();
                    break;
                case 5:
                    escape = true;
            }
        }
    }
}
