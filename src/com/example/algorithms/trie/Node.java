package com.example.algorithms.trie;

public class Node {

    private Character character;
    private Character[] children;

    public Node(Character character) {
        this.character = character;
        this.children = new Character[26];
    }
}
