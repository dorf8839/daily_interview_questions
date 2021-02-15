package com.company;

import java.util.Collections;
import java.util.LinkedList;

public class Main {

    //Given a stream of numbers, print the median of the list as each new element is added
    //Input is an int array
    //Loop through int array transferring each number to a list that is then sorted
    //Determine middle element on sorted list (average of two middle elements for even-numbered list)
    //if list.length % 2 == 1, then i = (list.length/2) + 1.  Get element at index i
    //if list.length % 2 == 0, then i = list.length/2.  Get element at index i and i + 1 and average for the result
    public static void main(String[] args) {
	    int[] nums = {2,1,5,7,2,0,5};
        LinkedList<Integer> tempNums = new LinkedList<>();
        int i;
        double result;
        for(int num : nums){
            tempNums.add(num);
            Collections.sort(tempNums);
            if(tempNums.size() == 1){
                result = tempNums.get(0);
            }else {
                i = (tempNums.size() / 2) - 1;
                if (tempNums.size() % 2 == 1) {
                    i++;
                    result = tempNums.get(i);
                } else {
                    double a = tempNums.get(i);
                    double b = tempNums.get(i + 1);
                    result = (a + b) / 2;
                }
            }
            System.out.println("Current median value is " + result);
        }
    }
}
