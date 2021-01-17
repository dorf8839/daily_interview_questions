package com.company;

public class Main {

    public static void main(String[] args) {
        Cons cons = new Cons(3, 4);
        int car = cons.car(cons.getPair());
        int cdr = cons.cdr(cons.getPair());
        System.out.println("The first element of the pair is " + car + " and the second element is " + cdr);
    }

    static class Cons {
        int a;
        int b;
        int[] pair;

        public Cons(int a, int b) {
            this.a = a;
            this.b = b;
            this.pair = new int[2];
            this.pair[0] = this.a;
            this.pair[1] = this.b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int[] getPair() {
            return pair;
        }

        public int car(int[] pair){
            return pair[0];
        }

        public int cdr(int[] pair){
            return pair[1];
        }
    }
}


