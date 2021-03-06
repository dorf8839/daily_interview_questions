package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}

class MyQueue {
    Stack mainStack;
    Stack tempStack;

    public MyQueue() {
        this.mainStack = new Stack();
        this.tempStack = new Stack();
    }

    public void enqueue(Object o){
         if(mainStack.isEmpty()){
             mainStack.push(o);
         }else{
             while(!mainStack.isEmpty()){
                 tempStack.push(mainStack.pop());
             }
             mainStack.push(o);
             while(!tempStack.isEmpty()){
                 mainStack.push(tempStack.pop());
             }
         }
    }

    public void dequeue(){
        if(mainStack.isEmpty()){
            System.out.println("The Queue is currently empty. Nothing to remove");
        }else{
            mainStack.pop();
        }
    }

    public void printQueue(){
        if(mainStack.isEmpty()){
            System.out.println("The Queue is currently empty. Nothing to remove");
        }else{
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
            while(!tempStack.isEmpty()){
                Object o = tempStack.pop();
                System.out.print(o + " ");
                mainStack.push(o);
            }
            System.out.println();
        }
    }
}
