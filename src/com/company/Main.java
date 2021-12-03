package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("dictionary.csv");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input words to translate");
        String wordsToTranslate = sc.nextLine();
        Dictionary.translate(wordsToTranslate, file);

        Dictionary.addToDictionary(file);


    }
}
