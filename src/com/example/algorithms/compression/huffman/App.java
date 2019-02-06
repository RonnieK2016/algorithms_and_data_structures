package com.example.algorithms.compression.huffman;

public class App {

    public static void main(String[] args) {
        HuffmanCode huffmanCode = new HuffmanCode();
        int[] frequencies = new int[128];
        String text = "AAAABBBBFDDDDDDDDDDDDDDDDDDDDDDSDDDSGGEETTGFFFF";
        for(char ch : text.toCharArray()) {
            frequencies[ch]++;
        }

        HuffmanTree huffmanTree = huffmanCode.buildTree(frequencies);
        huffmanCode.printCodes(huffmanTree, new StringBuilder());
    }
}
