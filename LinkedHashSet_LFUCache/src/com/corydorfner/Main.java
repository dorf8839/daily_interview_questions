package com.corydorfner;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        LFU lfu = new LFU(n);
        lfu.refer(1, 10);
        lfu.refer(2, 20);
        lfu.refer(3, 30);
        lfu.refer(1, 10);
        lfu.refer(4, 40);
        lfu.refer(5, 50);
        lfu.display();
    }
}

class LFU {
    Set<Node> cache;
    int capacity;

    static class Node{
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LFU(int capacity) {
        this.cache = new LinkedHashSet<>();
        this.capacity = capacity;
    }

    public boolean get(Node key){
        if(!cache.contains(key)){
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer(int key, int value){
        Node temp = new Node(key, value);
        if(!get(temp)){
            set(key, value);
        }
    }

    public void display(){
        LinkedList<Node> list = new LinkedList<>(cache);
        Iterator<Node> itr = list.descendingIterator();

        while(itr.hasNext()){
            System.out.print(itr.next().value + " ");
        }
    }

    public void set(int key, int value){
        if(cache.size() == capacity){
            Node firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }
        cache.add(new Node(key, value));
    }
}
