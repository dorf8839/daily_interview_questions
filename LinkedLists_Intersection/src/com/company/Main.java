package com.company;

import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList1.add(3);
        linkedList1.add(7);
        linkedList1.add(8);
        linkedList1.add(10);
        linkedList2.add(99);
        linkedList2.add(1);
        linkedList2.add(8);
        linkedList2.add(10);

        int intersect = intersection(linkedList1, linkedList2);
        System.out.println("The linked lists intersect at " + ((intersect == -1) ? "null" : intersect));
    }

    public static int intersection(LinkedList<Integer> linkedList1, LinkedList<Integer> linkedList2){
        if(linkedList1.size() == 0 || linkedList2.size() == 0){
            return -1;
        }
        Collections.sort(linkedList1);
        Collections.sort(linkedList2);

        int i = 0;
        int j = 0;

        while(!linkedList1.get(i).equals(linkedList2.get(j))){
            if ((linkedList1.get(1) > linkedList2.get(j))) {
                j++;
            } else {
                i++;
            }
            if(i >= linkedList1.size() || j >= linkedList2.size()){
                return -1;
            }
        }
        return linkedList1.get(i);
    }
}
