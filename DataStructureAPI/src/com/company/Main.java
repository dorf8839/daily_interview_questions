package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    eCommerce ecomm = new eCommerce(new ArrayList<>());
	    ecomm.addRecord(new Record(1));
	    ecomm.addRecord(new Record(2));
	    ecomm.addRecord(new Record(3));
	    ecomm.addRecord(new Record(4));
	    ecomm.addRecord(new Record(5));
	    ecomm.addRecord(new Record(6));
	    ecomm.addRecord(new Record(7));
	    
		System.out.println(ecomm.getRecordID(5));
    }
}
