package com.example.algorithms.compression.huffman;

public class HuffmanNode extends HuffmanTree {
    private HuffmanTree leftTree;
    private HuffmanTree rightTree;

    public HuffmanNode(HuffmanTree leftTree, HuffmanTree rightTree) {
        super(leftTree.getFrequency() + rightTree.getFrequency());
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public HuffmanTree getLeftTree() {
        return leftTree;
    }

    public HuffmanTree getRightTree() {
        return rightTree;
    }
}
