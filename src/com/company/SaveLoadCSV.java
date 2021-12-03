package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SaveLoadCSV {

    public static Map<String, String> loadDictionaryFromCSV(File file) throws FileNotFoundException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        String line;
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            int i = 0;
            String[] values = line.toLowerCase(Locale.ROOT).split(",");
            dictionary.put(values[0], values[1]);
            i++;
        }
        return dictionary;
    }

    public static void saveDictionary(Map<String, String> dictionary, File file) {
        PrintWriter pw = null;
        Set<String> keys = dictionary.keySet();
        try {
            pw = new PrintWriter(file);
            for (String value : keys
            ) {
                pw.println(value + "," + dictionary.get(value));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pw.close();
    }
}
