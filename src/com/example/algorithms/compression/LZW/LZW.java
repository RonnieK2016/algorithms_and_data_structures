package com.example.algorithms.compression.LZW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW {

    public static List<Integer> compress(String text) {
        Map<String, Integer> dict = new HashMap<>();
        int dictionarySize = 128;
        for(int i = 0; i < 128; i++) {
            dict.put(String.valueOf((char)i),i);
        }

        List<Integer> result = new ArrayList<>();

        StringBuilder tempString = new StringBuilder();

        for(char ch : text.toCharArray()) {
            tempString.append(ch);

            if(!dict.containsKey(tempString.toString())) {
                tempString.deleteCharAt(tempString.length() - 1);
                result.add(dict.get(tempString.toString()));
                dict.put(tempString.append(ch).toString(), dictionarySize++);
                tempString = new StringBuilder();
                tempString.append(ch);
            }
        }

        if(!tempString.toString().equals("")) {
            result.add(dict.get(tempString.toString()));
        }

        return result;
    }
}
