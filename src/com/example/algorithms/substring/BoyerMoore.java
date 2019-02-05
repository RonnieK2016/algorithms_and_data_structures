package com.example.algorithms.substring;

public class BoyerMoore {

    private char[] pattern;
    private int[] mismatchTable;

    public BoyerMoore( String pattern) {
        this.pattern = pattern.toCharArray();
        mismatchTable = new int[128];
        preComputeMismatch();
    }

    private void preComputeMismatch() {
        for(int i = 0; i < mismatchTable.length; i++) {
            mismatchTable[i] = -1;
        }

        for(int i = 0; i < pattern.length; i++) {
            mismatchTable[pattern[i]] = i;
        }
    }

    public int searchIn(String text) {
        char[] tArr = text.toCharArray();

        int skip;
        for(int i = 0; i < tArr.length - pattern.length; i+= skip) {
            skip = 0;

            for(int j = pattern.length - 1; j > -1; j--) {
                if(pattern[j] != tArr[i + j]) {
                    skip = Math.max(1, j - mismatchTable[tArr[i+j]]);
                    break;
                }
            }

            if(skip == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BoyerMoore boyerMoore = new BoyerMoore("baa");
        System.out.println(boyerMoore.searchIn("aaaaa"));
        System.out.println(boyerMoore.searchIn("aabaaa"));
    }
}
