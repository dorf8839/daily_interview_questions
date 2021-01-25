package com.company;

public class Main {

    public static void main(String[] args) {
        int totalSteps = 5;
        int[] stepCount = new int[]{1,3,5};
        int results = staircase(totalSteps, stepCount);
        System.out.println("Total combinations = " + results);
    }

    private static int staircase(int totalSteps, int[] stepCount){
        if(totalSteps < 0){
            return 0;
        }else if(totalSteps == 0){
            return 1;
        }else {
            int sum=0;
            for(int step : stepCount){
                sum += staircase(totalSteps - step, stepCount);
            }
            return sum;
        }
    }
}
