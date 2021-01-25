package com.company;

public class Main {

    public static void main(String[] args) {
        int totalSteps = 5;
        int[] stepCount = new int[]{1,3,5};
        System.out.println("Number of ways to climb the given staircase 1 or 2 steps at a time: " + staircase(totalSteps));
        System.out.println("Number of ways to climb the given staircase using the given step count: " + staircase(totalSteps, stepCount));
    }

    private static int staircase(int totalSteps){
        if(totalSteps <= 1){
            return 1;
        }
        return staircase(totalSteps - 1) + staircase(totalSteps - 2);
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
