package com.company;

import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
        BST tree = new BST();
        char[] in = {'3','+','2','*','4','+','5'};
        char[] pre = {'*','+','3','2','+','4','5'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len-1);

        //building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is: ");
        tree.printInorder(root);
        System.out.println();
        System.out.println("The binary expression tree evaluates to: " + tree.evaluate(root));
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BST{
        Node root;
        int preIndex = 0;

        //Recursive function to construct binary of size len from
        //Inorder traversal in[] and Preorder traversal pre[].
        //Initial values of inStrt and inEnd should be 0 and len -1.
        //The function doesn't do any error checking for cases where
        //inorder and preorder do not form a tree.
        Node buildTree(char[] in, char[] pre, int inStrt, int inEnd){
            if(inStrt > inEnd){
                return null;
            }

            //Pick current node from Preorder traversal using preIndex and increment preIndex
            Node tNode = new Node(pre[preIndex++]);

            //If this node has no children then return
            if(inStrt == inEnd){
                return tNode;
            }

            //Else find the index of this node in Inorder Traversal
            int inIndex = search(in, inStrt, inEnd, tNode.data);

            //Using index in Inorder traversal, construct left and right subtrees
            tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
            tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

            return tNode;
        }

        //UTILITY FUNCTIONS

        //Function to find index of value in arr[start...end]
        //The function assumes that value is present in in[]
        int search(char[] arr, int strt, int end, char value){
            int i;
            for(i = strt; i <= end; i++){
                if(arr[i] == value){
                    return i;
                }
            }
            return i;
        }

        //This function is here just to test buildTree()
        void printInorder(Node node){
            if(node == null){
                return;
            }

            //first recur on left child
            printInorder(node.left);

            //Then print the data of the node
            System.out.print(node.data + " ");

            //Now recur on right child
            printInorder(node.right);
        }

        int evaluate(Node node){
            switch (node.data){
                case '+':
                    return evaluate(node.left) + evaluate(node.right);
                case '-':
                    return evaluate(node.left) - evaluate(node.right);
                case '*':
                    return evaluate(node.left) * evaluate(node.right);
                case '/':
                    return evaluate(node.left) / evaluate(node.right);
                default:
                    return Character.getNumericValue(node.data);
            }
        }
    }
}
