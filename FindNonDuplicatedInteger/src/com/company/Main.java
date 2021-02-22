package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        int[] intArray = new int[] {6,1,3,3,3,6,6};
        int[] intArray = new int[] {13,19,13,13};
        ArrayList<Integer> input = new ArrayList<>();

        for(int i = 0; i < intArray.length; i++){
            input.add(intArray[i]);
        }
        Collections.sort(input);
        int prev = input.get(0);
        for(int i = 1; i < input.size(); i++){
            if(i == input.size()-1){
                prev = input.get(i);
            }else if(input.get(i) != prev){
                break;
            }
        }
        System.out.println("The non-duplicated integer is " + prev);
    }
}
