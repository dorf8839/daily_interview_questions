package com.corydorfner;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Interval[] arr = new Interval[4];
//        arr[0] = new Interval(6, 8);
//        arr[1] = new Interval(1, 9);
//        arr[2] = new Interval(2, 4);
//        arr[3] = new Interval(4, 7);
        arr[0] = new Interval(1,3);
        arr[1] = new Interval(5,8);
        arr[2] = new Interval(4,10);
        arr[3] = new Interval(20,25);
        MergeOverlappingIntervals.mergeIntervals(arr);
    }
}

//An Interval
class Interval{
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MergeOverlappingIntervals {
    //Function that takes a set of intervals, merges
    //overlapping intervals and prints the result
    public static void mergeIntervals(Interval[] arr){
        //Sort Intervals in increasing order of start time
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));

        int index = 0; //Stores index of last time in output array (modified arr[])

        //Traverse all input Intervals
        for(int i = 1; i < arr.length; i++){
            //If this is not first Interval and overlaps with previous one
            if(arr[index].end >= arr[i].start && arr[index].start <= arr[i].end){
                //Merge previous and current Intervals
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            }else{
                index++;
                arr[index] = arr[i];
            }
        }

        //Now arr[0..index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for(int i = 0; i <= index; i++){
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
        }
    }
}
