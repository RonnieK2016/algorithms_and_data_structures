package com.example.algorithms.compression.huffman;

public class HuffmanLeaf extends HuffmanTree {

    private char character;

    public HuffmanLeaf(int frequency) {
        super(frequency);
    }

    public HuffmanLeaf(int frequency, char character) {
        super(frequency);
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
