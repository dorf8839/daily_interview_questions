package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    int headCount = 0;
	    int tailCount = 0;
	    int total = 0;
        for(int i = 0; i < 10000; i++){
            if(tossUnBiased() == 1){
                headCount++;
                total++;
            }else{
                tailCount++;
                total++;
            }
        }
        System.out.println("Heads %: " + (double) headCount/total + "; Tails %: " + (double) tailCount/total);
    }

    public static int tossBiased(){
        int result = (int) (Math.random() * 3);
        return result;
    }

    public static int tossUnBiased(){
        int test1 = tossBiased();
        int test2 = tossBiased();

        if(test1 == 0 && test2 == 1){
            return 0;
        }
        if(test1 == 1 && test2 == 0){
            return 1;
        }
        return tossUnBiased();
    }
}

