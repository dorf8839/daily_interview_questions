package com.corydorfner;

public class Main {

    public static void main(String[] args) {
	    BST tree = new BST();
	    tree.insert(50);
	    tree.insert(30);
	    tree.insert(20);
	    tree.insert(40);
	    tree.insert(70);
	    tree.insert(60);
	    tree.insert(80);

        System.out.println("Original Tree");
	    tree.display(tree.root);
        System.out.println();
	    tree.inverse(tree.root);

        System.out.println("Inverted Tree");
	    tree.display(tree.root);
    }
}

class BST {
    Node root;

    class Node {
        int data;
        Node left, right;

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
        }else{
            node.right = this.insertRec(node.right, data);
        }
        return node;
    }

    public void display(Node node){
        if(node == null){
            return;
        }
        //Preorder Traversal
//        System.out.print(node.data + "->");
        display(node.left);
        //Inorder Traversal
        System.out.print(node.data + "->");
        display(node.right);
        //Postorder Traversal
//        System.out.print(node.data + "->");
    }

    public void inverse(Node node){
        if(node == null){
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        inverse(node.left);
        inverse(node.right);
    }
}
