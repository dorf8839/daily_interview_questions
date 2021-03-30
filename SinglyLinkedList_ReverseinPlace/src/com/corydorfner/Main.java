package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    SLL sll = new SLL();
	    sll.addNode(1);
	    sll.addNode(2);
	    sll.addNode(3);
	    sll.addNode(4);
	    sll.addNode(5);
	    sll.display();
	    sll.head = sll.reverse(sll.head);
	    sll.display();
    }
}

class SLL {

    public Node head = null;
    public Node tail = null;
    public int size;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void display(){
        Node current = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list");
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node reverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //reverse the rest list and put the first element at the end
        Node rest = reverse(head.next);
        head.next.next = head;

        //tricky step -- see the diagram in https://www.geeksforgeeks.org/reverse-a-linked-list/
        head.next = null;

        //fix the head pointer
        return rest;
    }
}
