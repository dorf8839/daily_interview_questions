package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Character[] chars = new Character[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        ArrayList<Character> input = new ArrayList<>();
        input.addAll(Arrays.asList(chars));
        partition(input);
        for(int i = 0; i < input.size(); i++){
            System.out.print(input.get(i) + " ");
        };
    }

    public static void partition(ArrayList<Character> input){
        int low = 0;
        int mid = 0;
        int high = input.size() - 1;
        char temp;

        while(mid <= high){
            if(input.get(mid) == 'R'){
                temp = input.get(low);
                input.set(low, input.get(mid));
                input.set(mid, temp);
                low++;
                mid++;
            }else if(input.get(mid) == 'G'){
                mid++;
            }else{
                temp = input.get(mid);
                input.set(mid, input.get(high));
                input.set(high, temp);
                high--;
            }
        }
    }
}
