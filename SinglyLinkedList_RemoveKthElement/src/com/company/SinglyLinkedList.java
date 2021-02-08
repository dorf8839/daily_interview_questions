package com.company;

public class SinglyLinkedList {

    public Node head = null;
    public Node tail = null;
    public int size;

    public class Node {
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
        System.out.println("Nodes of singly linked list:");
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printNthFromLast(int n){
        Node fast = head;
        Node slow = head;
        Node prev = null;

        int count = 0;
        if(head != null){
            while(count < n){
                if(fast == null){
                    System.out.println(n + " is greater than the no. of nodes in the list");
                    return;
                }
                fast = fast.next;
                count++;
            }
            if(fast == null){
                head = head.next;
                if(head != null){
                    System.out.println("Node no. " + n + " from last is " + head.data);
                }
            }else{
                while(fast != null){
                    prev = slow;
                    slow = slow.next;
                    fast = fast.next;
                }
                System.out.println("Node no. " + n + " from last is " + slow.data);
                prev.next = slow.next;
                System.out.println("Element " + slow.data + " has been removed");
            }
        }
    }
}
