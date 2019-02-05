package com.example.algorithms.trie;

public class App {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("addition");
        trie.insert("addiction");
        trie.insert("addendum");
        trie.insert("additive");
        System.out.println("Searching for 'test' " + trie.search("test", false));
        System.out.println("Searching for 'tes' " + trie.search("tes", true));
        System.out.println("Searching for 'tess' " + trie.search("tess", false));
        System.out.println("Suggestions for 'add' " + trie.getSuggestions("add"));
        System.out.println("Getting sorted set of strings " + trie.getSuggestions(""));
        System.out.println("Getting longest common prefix " + trie.getLCP());
    }
}
