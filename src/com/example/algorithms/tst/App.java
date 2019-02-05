package com.example.algorithms.tst;

public class App {

    public static void main(String[] args) {
        TernarySearchTree tree = new TernarySearchTree();

        tree.put("apple",1);
        tree.put("pear",2);
        tree.put("apricot",3);
        tree.put("watermelon",4);

        System.out.println("Searching for 'apple' " + tree.search("apple"));
        System.out.println("Searching for 'melon' " + tree.search("melon"));
        System.out.println("Searching for 'pear' " + tree.search("pear"));
    }
}
