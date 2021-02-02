package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] dur = new int[][]{{30,75}, {0,50}, {60,150}};
//        int rooms = numRooms(dur);
        int rooms = minMeetingRooms(dur);
        System.out.println("You will need " + rooms + ((rooms == 1) ? " room." : " rooms."));
    }

    public static int numRooms(int[][] dur){
        if(dur.length <= 1){
            return dur.length;
        }

        ArrayList<Integer> startTimes = new ArrayList<>();
        ArrayList<Integer> endTimes = new ArrayList<>();

        for(int i = 0; i < dur.length; i++){
            startTimes.add(dur[i][0]);
            endTimes.add(dur[i][1]);
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int startPointer = 0;
        int endPointer = 0;
        int rooms = 0;

        while(startPointer < dur.length){
            if(startTimes.get(startPointer++) >= endTimes.get(endPointer)){
                ++endPointer;
            }else{
                ++rooms;
            }
        }
        return rooms;
    }

    public static int minMeetingRooms(int[][] dur){
        Arrays.sort(dur, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for(int[] itv : dur) {
            if(heap.isEmpty()){
                count++;
            }else{
                if(itv[0] >= heap.peek()){
                    heap.poll();
                }else{
                    count++;
                }
            }
            heap.offer(itv[1]);
        }
        return count;
    }
}
