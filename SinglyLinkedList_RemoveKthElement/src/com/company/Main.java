package com.company;

public class Main {

    //Given integer k, remove the kth last element from the list
    //Must be done in constant space and one pass
    public static void main(String[] args) {
	    SinglyLinkedList sList = new SinglyLinkedList();
	    for(int i = 1; i <= 100; i++){
	    	sList.addNode(i);
		}

	    sList.display();
		System.out.println();

	    int k = 2;
	    sList.printNthFromLast(k);
		System.out.println();
	    sList.display();
    }


}


