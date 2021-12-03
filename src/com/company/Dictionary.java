package com.company;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Dictionary {

    public static void translate(String words, File file) {
        Map<String, String> dictionary = new HashMap<>();
        try {
            dictionary = SaveLoadCSV.loadDictionaryFromCSV(file);
        } catch (IOException e) {
            System.out.println("There's no such a dictionary " + file);
        }
        String[] word;
        String translation = "";
        word = words.toLowerCase(Locale.ROOT).split(" ");
        for (int i = 0; i < word.length; i++) {
            if (dictionary.containsKey(word[i])) {
                translation = translation + "" + dictionary.get(word[i]) + " ";
            } else {
                translation = translation + "" + "(" + word[i] + " - word did not found)" + " ";
            }
        }
        System.out.println(translation);
    }

    public static void addToDictionary(File file) {
        Map<String, String> dictionary = new HashMap<>();
        try {
            dictionary = SaveLoadCSV.loadDictionaryFromCSV(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Adding words into the dictionary...");
        System.out.println("Input english word");
        Scanner sc = new Scanner(System.in);
        String eng = sc.nextLine();
        System.out.println("Input german translation for " + eng);
        String ger = sc.nextLine();

        dictionary.put(eng, ger);
        System.out.println(eng +" - "+ger +" added");
        System.out.println(dictionary);
        String translation = eng + "," + ger;
        SaveLoadCSV.saveDictionary(dictionary, file);
    }
}

