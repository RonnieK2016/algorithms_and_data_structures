package com.example.algorithms.trie;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        char[] a = word.toCharArray();
        Node c = root;
        for(char ch : a) {
            if(c.getChildren()[ch - 'a'] == null) {
                c.getChildren()[ch - 'a'] = new Node(ch);
            }
            c = c.getChildren()[ch - 'a'];
        }
        c.setLeaf(true);
    }

    public boolean search(String word) {
        char[] a = word.toCharArray();
        Node c = root;
        for(char ch : a) {
            if(c.getChildren()[ch - 'a'] == null) {
                return false;
            }
            c = c.getChildren()[ch - 'a'];
        }

        return c.isLeaf();
    }
}
