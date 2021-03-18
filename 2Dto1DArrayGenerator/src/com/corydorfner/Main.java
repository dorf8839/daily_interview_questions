package com.corydorfner;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        int[][] twoDArray = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        int[][] twoDArray = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        twoDToOneDArray(twoDArray);
    }

    public static void twoDToOneDArray(int[][] twoDArray){
        ArrayList<Integer> oneDArray = new ArrayList<>();
        int topRow = 0;
        int rightCol = twoDArray[0].length - 1;
        int botRow = twoDArray.length - 1;
        int leftCol = 0;

        while((topRow <= botRow) && (leftCol <= rightCol)){
            for(int i = leftCol; i <= rightCol; i++){
                oneDArray.add(twoDArray[topRow][i]);
            }

            topRow++;

            for(int i = topRow; i <= botRow; i++){
                oneDArray.add(twoDArray[i][rightCol]);
            }

            rightCol--;

            if(topRow <= botRow){
                for(int i = rightCol; i >= leftCol; i--){
                    oneDArray.add(twoDArray[botRow][i]);
                }
                botRow--;
            }

            if(leftCol <= rightCol){
                for(int i = botRow; i >= topRow; i--){
                    oneDArray.add(twoDArray[i][leftCol]);
                }
                leftCol++;
            }
        }
        System.out.println(oneDArray.toString());
    }
}
