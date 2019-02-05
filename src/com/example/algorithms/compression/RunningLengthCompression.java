package com.example.algorithms.compression;

public class RunningLengthCompression {

    public static String encode(String text) {
        char[] arr = text.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            int length = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] == arr[i]) {
                    length++;
                    continue;
                }
                break;
            }

            i += length - 1;

            if(length > 1) {
                result.append(length);
            }

            result.append(arr[i]);
        }
        return result.toString();
    }

    private static String decode(String compressed) {
        char[] arr = compressed.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(Character.isDigit(arr[i])) {
                StringBuilder numbStr = new StringBuilder();
                while(Character.isDigit(arr[i])) {
                    numbStr.append(arr[i]);
                    i++;
                }
                int j = 0;
                int num = Integer.parseInt(numbStr.toString());
                while(j < num) {
                    result.append(arr[i]);
                    j++;
                }
            }
            else {
                result.append(arr[i]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String compressed = RunningLengthCompression.encode("AAAABBBBFDDDDDDDDDDDDDDDDDDDDDDSDDDSGGEETTGFFFF");
        System.out.println("Compressing string 'AAAABBBBFDDDDDDDDDDDDDDDDDDDDDDSDDDSGGEETTGFFFF' " + compressed);
        String decompressed = RunningLengthCompression.decode(compressed);
        System.out.println("Decompresing string 'AAAABBBBFDDDDDDDDDDDDDDDDDDDDDDSDDDSGGEETTGFFFF' " + decompressed);


    }

}
