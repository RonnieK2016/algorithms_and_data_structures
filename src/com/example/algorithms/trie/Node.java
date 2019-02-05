package com.example.algorithms.trie;

public class Node {

    private char character;
    private Node[] children;
    private boolean leaf;
    private boolean visited;

    public Node(char character) {
        this.character = character;
        this.children = new Node[26];
    }

    public Node[] getChildren() {
        return children;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
