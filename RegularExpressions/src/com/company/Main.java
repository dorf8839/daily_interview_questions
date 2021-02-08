package com.company;

public class Main {

    public static void main(String[] args) {
	    String regExp = ".*at";
	    String test = "chat";

        System.out.println(test.matches(regExp));
    }
}
