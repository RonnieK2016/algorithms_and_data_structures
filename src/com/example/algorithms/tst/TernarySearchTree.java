package com.example.algorithms.tst;

public class TernarySearchTree {
    private Node rootNode;

    public void put(String key, int value) {
        put(rootNode, key.toCharArray(), value, 0);
    }

    private Node put(Node node, char[] chars, int value, int index) {

        char ch = chars[index];

        if(node == null) {
            node = new Node(ch);

            if(this.rootNode == null) {
                this.rootNode = node;
            }
        }

        if(node.getCharacter() < ch) {
            node.setLeftNode(put(node.getLeftNode(), chars, value, index));
        }
        else if (node.getCharacter() > ch) {
            node.setRightNode(put(node.getRightNode(), chars, value, index));
        }
        else if(index < chars.length - 1) {
            node.setMiddleNode(put(node.getMiddleNode(), chars, value, index + 1));
        }
        else {
            node.setValue(value);
        }

        return node;
    }

    public Integer search(String key) {
        return search(rootNode, key.toCharArray(), 0);
    }

    private Integer search(Node node, char[] chars, int index) {
        if (node == null) {
            return null;
        }

        char ch = chars[index];

        if(node.getCharacter() < ch) {
            return search(node.getLeftNode(), chars, index);
        }
        else if (node.getCharacter() > ch) {
            return search(node.getRightNode(), chars, index);
        }
        else if(index < chars.length - 1) {
            return search(node.getMiddleNode(), chars, index + 1);
        }
        else {
            return node.getValue();
        }
    }

}
