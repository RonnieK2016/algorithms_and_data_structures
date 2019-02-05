package com.example.algorithms.trie;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

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

    public boolean search(String word, boolean matchPartial) {
        char[] a = word.toCharArray();
        Node c = root;
        for(char ch : a) {
            if(c.getChildren()[ch - 'a'] == null) {
                return false;
            }
            c = c.getChildren()[ch - 'a'];
        }

        return matchPartial || c.isLeaf();
    }

    private void collectResults(Node node, List<String> result, StringBuilder word) {
        if(node.isLeaf()) {
            result.add(word.toString());
        }

        for(Node child : node.getChildren()) {
            if(child != null) {
                StringBuilder newWord = new StringBuilder().append(word);
                collectResults(child, result, newWord.append(child.getCharacter()));
            }
        }
    }

    public List<String> getSuggestions(String prefix) {
        List<String> result = new ArrayList<>();
        char[] a = prefix.toCharArray();
        Node c = root;
        for(char ch : a) {
            if(c.getChildren()[ch - 'a'] == null) {
                return result;
            }
            c = c.getChildren()[ch - 'a'];
        }

        collectResults(c, result, new StringBuilder().append(prefix));

        return  result;
    }
}
