package com.example.algorithms.compression.LZW;

public class App {

    public static void main(String[] args) {
        System.out.println("Compressing 'CARRARCARCAR' with LZW " + LZW.compress("CARRARCARCAR"));
    }
}
