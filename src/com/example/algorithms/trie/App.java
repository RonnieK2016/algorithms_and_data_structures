package com.example.algorithms.trie;

public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("test");
        System.out.println("Searching for 'test' " + trie.search("test"));
        System.out.println("Searching for 'tes' " + trie.search("tes"));
        System.out.println("Searching for 'tess' " + trie.search("tess"));
    }
}
