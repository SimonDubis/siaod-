package com;
import java.util.Scanner;

public class Dict {

    LinkedList[] lists = new LinkedList[26];
    int hash(String key){
        return ((int)key.charAt(0) - (int)'A');
    }

    void add(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слово на английском: ");
        String key = standardize(scan.nextLine());
        while ((key.charAt(0)<'A')||(key.charAt(0)>'Z')){
            System.out.println("Слово должно начинаться с буквы латинского алфавита.");
            System.out.println("Введите слово на английском: ");
            key = standardize(scan.nextLine());
        }
        System.out.println("Введите русский перевод: ");
        String reference = scan.nextLine();
        if(lists[hash(key)].search(key) == null){
            lists[hash(key)].add(key, reference);
        }else{
            System.out.println("Данное слово уже существует в словаре");
        }
    }

    void print(){
        for(int i = 0; i < lists.length; i++){
            System.out.println((char)(i + (int)'A'));
            lists[i].print();
        }
    }

    void search(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String key = standardize(scan.nextLine());
        while ((key.charAt(0)<'A')||(key.charAt(0)>'Z')){
            System.out.println("Слово должно начинаться с буквы латинского алфавита.");
            System.out.println("Введите слово: ");
            key = standardize(scan.nextLine());
        }
        System.out.println(lists[hash(key)].search(key) == null ? "Данного слова нет." : lists[hash(key)].search(key));
    }

    void remove(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слово для удаления: ");
        String key = standardize(scan.nextLine());
        while ((key.charAt(0)<'A')||(key.charAt(0)>'Z')){
            System.out.println("Слово должно начинаться с буквы латинского алфавита.");
            System.out.println("Введите слово для удаления: ");
            key = standardize(scan.nextLine());
        }
        System.out.println(lists[hash(key)].remove(key) ? "Успешно удалено." : "Данного слова нет.");

    }

    String standardize(String str){
        char firstChar = Character.toUpperCase(str.charAt(0));
        String remainder = str.substring(1).toLowerCase();
        return  firstChar + remainder;
    }

    void fill(){
        for(int i = 0; i < lists.length; i++){
            lists[i] = new LinkedList();
        }
        String[][] notes = {
                {"Abandon","оставлять, отказываться, покидать"},
                {"Ability","способность, умение"},
                {"Absence","отсутствие"},
                {"Accept","принять"},
                {"Active","энергичный, активный, оживленный"},
                {"Ambulance","машина скорой помощи"},
                {"Appetite","аппетит"},
                {"Arm","рука, плечо"},
                {"Avowal","признание, заявление, прямое утверждение"},
                {"Broad","широкий, обширный"},
                {"Broadcast","радиовещательный, передавать по радио"},
                {"Corner","угол"},
                {"Crowd","толпа"},
                {"Cynical","циничный"},
                {"Debt","долг"},
                {"Dream","мечта, сон, сновидение, грёза"},
                {"Elbow","локоть"},
                {"Embassy","посольство"},
                {"Flood","наводнение"},
                {"Food","еда"},
                {"Glimpse","проблеск, слабая вспышка"},
                {"Issue","ошибка"},
                {"Jail","тюрьма"},
                {"Jump","прыгать"},
                {"Kerb","обочина"},
                {"Lord","повелитель, господин"},
                {"Machine","машина, аппарат"},
                {"Mad","сумасщедший, помешанный"},
                {"Novel","рассказ, новелла"},
                {"Oral","устный"},
                {"Panic","паника"},
                {"Play","играть"},
                {"Rage","ярость, бешенство, гнев"},
                {"Rainbow","радуга"},
                {"Stuff","вещество, материал"},
                {"Toxic","ядовитый, токсичный"},
                {"Tunnel","туннель"},
                {"Unemployed","безработный"},
                {"Unity","единство"},
                {"Valid","действительный, правомерный"},
                {"Verify","проверять, подтверждать"},
                {"Want","хотеть"},
                {"Witness","свидетель, очевидец"},
                {"Wrist","запястье, манжета"},
                {"Xerox","копировальный аппарат, ксерокс"},
                {"Yawn","зевота, зевок"},
                {"Youth","юность, молодость"},
                {"Zoom","изменять масштаб"},
        };

        for (int i = 0; i < notes.length; i++){
            lists[hash(notes[i][0])].add(notes[i][0], notes[i][1]);
        }
    }
}
