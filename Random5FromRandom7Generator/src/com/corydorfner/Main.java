package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    for(int i = 0; i < 100; i++){
            System.out.println(rand5());
        }
    }

    public static int rand7(){
        return (int) (Math.random() * 7) + 1;
    }

    public static int rand5(){
        double random7 = ((double) rand7() - 1) / 7;
        return (int) (random7 * 5) + 1;
    }
}
