package com.company;

public class Main {

    public static void main(String[] args) {
//	    int x = 2, y = 10;
	    int x = 2, y = 5;

        System.out.println(x + "^" + y + " = " + exponentiate(x, y));
    }

    public static int exponentiate(int x, int y){
        int base = x;
        if(y < 0){
            base = 1 / x;
        }
        int coeff = 1;
        while(y > 1){
            if(y % 2 == 0){
                base *= base;
                y = y / 2;
            }else{
                coeff *= base;
                base *= base;
                y = (y - 1) / 2;
            }
        }
        return coeff * base;
    }
}
