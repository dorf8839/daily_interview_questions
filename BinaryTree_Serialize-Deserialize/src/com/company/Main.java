package com.company;

public class Main {

    public static void main(String[] args) {
        int[] preorder = {5,2,1,3,4,7,6,8};

        DeserializeBinarySearchTree solution = new DeserializeBinarySearchTree();

        int[] currIndex = new int[1];
        currIndex[0] = 0;

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        DeserializeBinarySearchTree.TreeNode root = solution.deserializeArrayOptimized(preorder, currIndex, min, max);

        System.out.print("Inorder array constructed BAST is: " );
        solution.printInOrder(root);

        System.out.println("" );

        System.out.print("Preorder array constructed BST is: ");
        solution.printPreorder(root);

        System.out.println("Serialized array is: " + solution.serializeArray(root));
    }

}


