package com.example.algorithms.compression.huffman;

import java.util.PriorityQueue;

public class HuffmanCode {

    public HuffmanTree buildTree(int[] frequencies) {
        PriorityQueue<HuffmanTree> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] > 0) {
                priorityQueue.add(new HuffmanLeaf(frequencies[i], (char) i));
            }
        }

        while(priorityQueue.size() > 1) {
            HuffmanTree rightNode = priorityQueue.poll();
            HuffmanTree leftNode = priorityQueue.poll();
            priorityQueue.add(new HuffmanNode(leftNode, rightNode));
        }

        return priorityQueue.poll();
    }

    public void printCodes(HuffmanTree huffmanTree, StringBuilder code) {
        if(huffmanTree instanceof  HuffmanLeaf) {
            System.out.println(((HuffmanLeaf) huffmanTree).getCharacter() + " - " + huffmanTree.getFrequency()
                    + " - " + code.toString());
        }
        else {
            code.append("0");
            printCodes(((HuffmanNode) huffmanTree).getLeftTree(), code);
            code.deleteCharAt(code.length() - 1);
            code.append("1");
            printCodes(((HuffmanNode) huffmanTree).getRightTree(), code);
            code.deleteCharAt(code.length() - 1);
        }
    }
}
