package com.corydorfner;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    BST tree = new BST();

	    tree.insert(50);
	    tree.insert(30);
	    tree.insert(20);
//	    tree.insert(10);
	    tree.insert(40);
	    tree.insert(70);
	    tree.insert(60);
	    tree.insert(80);
//	    tree.insert(90);

        System.out.println(tree.deepestNode(tree.root));
    }
}

class BST {
    //Keeps track of maximum level seen so far
    int maxLevel = -1;
    //Keeps track of deepest node so far
    int res = -1;
    Node root;

    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BST() {
        this.root = null;
    }

    public void insert(int data){
        this.root = this.insertRec(this.root, data);
    }

    Node insertRec(Node node, int data){
        if(node == null){
            this.root = new Node(data);
            return this.root;
        }

        if(data < node.data) {
            node.left = this.insertRec(node.left, data);
        }else {
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    //Function to return the highest level
    private void find(Node root, int level){
        if(root != null){
            find(root.left, ++level);
            //Update level and resume
            if(level > maxLevel){
                res = root.data;
                maxLevel = level;
            }
            find(root.right, level);
        }
    }

    //Function to return the deepest node
    public int deepestNode(Node root){
        find(root, 0);
        return res;
    }
}
