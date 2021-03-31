package com.corydorfner;

public class Main {

    public static void main(String[] args) {
        int k = 3; //Number of linked lists

        //An array of pointers storing the head nodes of the linked lists
        Node[] arr = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        //Merge all lists
        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }

    /* Takes two lists sorted in increasing order, and merge their nodes together to make
    one big sorted list.  Below function takes O(log N) extra space for recursive calls,
    but it can be easily modified to work with same time and O(1) extra space */
    public static Node sortedMerge(Node a, Node b){
        Node result;

        //Base cases
        if(a == null) return b;
        else if(b == null) return a;

        //Pick either a or b, and recur
        if(a.data <= b.data){
            result = a;
            result.next = sortedMerge(a.next, b);
        }else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    //The main function taht takes an array of lists arr[0..last] and generates the sorted output
    public static Node mergeKLists(Node[] arr, int last){
        //repeat until only one list is left
        while(last != 0){
            int i = 0, j = last;
            //(i,j) forms a pair
            while(i < j){
                //merge List i with List j and store merged list in List i
                arr[i] = sortedMerge(arr[i], arr[j]);
                //consider next pair
                i++;
                j--;
                //If all pairs are merged, update last
                if(i >= j) last = j;
            }
        }
        return arr[0];
    }

    //Function that prints nodes in a given linked list
    public static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}