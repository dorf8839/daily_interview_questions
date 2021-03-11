package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(13);
        input.add(18);
        input.add(25);
        input.add(2);
        input.add(8);
        input.add(10);
//        int k = 8;
        int k = 7;
        int index = input.indexOf(k);
        System.out.println("The index of element " + k + " is " + (index>-1 ? index : "NULL"));
    }
}
