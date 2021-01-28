package com.company;

import java.util.ArrayList;

public class eCommerce {
    ArrayList<Record> records;

    public eCommerce(ArrayList<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record){
        this.records.add(record);
    }

    public int getRecordID(int i){
        return this.records.get(i).getOrderID();
    }
}
