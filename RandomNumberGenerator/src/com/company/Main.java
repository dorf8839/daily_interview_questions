package com.company;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            System.out.println(rand7());
        }
    }

    private static double rand5(){
        int range = 5;
        double rand = (Math.random() * range) + 1;
        return rand;
    }

    private static int rand7(){
        double rand = rand5();
        int range = 7;
        int newRand = (int) (((rand - 1) / 5) * range) + 1;
        return newRand;
    }
}
