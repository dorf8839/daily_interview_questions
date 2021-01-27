package com.company;

public class Main {

    public static void main(String[] args) {
        String[] stream = new String[]{"apple", "banana", "orange", "strawberry", "blueberry", "raspberry", "lime", "lemon", "stuff"};
        int rand = (int)(Math.random() * stream.length);
        System.out.println("Your randomly generated element is " + stream[rand]);
    }
}
