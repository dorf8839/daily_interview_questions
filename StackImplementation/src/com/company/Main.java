package com.company;

public class Main {

    StackNode root;

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    public boolean isEmpty(){
        if(root == null) {
            return true;
        }else{
            return false;
        }
    }

    public void push(int data){
        StackNode newNode = new StackNode(data);

        if(root == null){
            root = newNode;
        }else{
            StackNode temp = root;
            root = newNode;
            newNode.next = temp;
        }
        System.out.println(data + " pushed to stack");
    }

    public int pop(){
        int popped = Integer.MIN_VALUE;
        if(root == null){
            System.out.println("Stack is empty");
        }else{
            popped = root.data;
            root = root.next;
        }
        return popped;
    }

    public int peek(){
        if(root == null){
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }else{
            return root.data;
        }
    }

    public int max(){
        int max = Integer.MIN_VALUE;
        if(root == null){
            System.out.println("Stack is empty");
        }else {
            StackNode curr = root;
            while(curr != null){
                if(curr.data > max){
                    max = curr.data;
                }
                curr = curr.next;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main sll = new Main();

        sll.push(10);
        System.out.println("The current max element is " + sll.max());
        sll.push(20);
        System.out.println("The current max element is " + sll.max());
        sll.push(30);
        System.out.println("The current max element is " + sll.max());

        System.out.println(sll.pop() + " popped from stack");

        System.out.println("Top element is " + sll.peek());

        System.out.println("Empty stack: " + sll.isEmpty());

        System.out.println(sll.pop() + " popped from stack");
        System.out.println("The current max element is " + sll.max());
        System.out.println(sll.pop() + " popped from stack");
        System.out.println("The current max element is " + sll.max());

        System.out.println("Top element is " + sll.peek());

        System.out.println("Empty stack: " + sll.isEmpty());
    }



}
