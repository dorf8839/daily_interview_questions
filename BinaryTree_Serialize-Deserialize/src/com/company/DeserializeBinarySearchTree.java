package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class DeserializeBinarySearchTree {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void printInOrder(TreeNode root){
        if(root == null) return;

        printInOrder(root.left);
        System.out.print(" " + root.val + ",");
        printInOrder(root.right);
    }

    public void printPreorder(TreeNode root){
        if(root == null) return;

        System.out.println(" " + root.val + ",");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public TreeNode deserializeArrayOptimized(int[] preorder, int[] currIndex, int min, int max){
        if(currIndex[0] >= preorder.length) return null;

        TreeNode root = null;

        if((preorder[currIndex[0]] > min) && (preorder[currIndex[0]] < max)){
            root = new TreeNode((preorder[currIndex[0]]));
            currIndex[0] += 1;
            root.left = deserializeArrayOptimized(preorder, currIndex, min, root.val);
            root.right = deserializeArrayOptimized(preorder, currIndex, root.val, max);
        }
        return root;
    }

    public String serializeArray(TreeNode root){
        ArrayList<String> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode h = q.poll();
            if (h != null) {
                list.add(String.valueOf(h.val));
                q.offer(h.left);
                q.offer(h.right);
            }
        }

        return String.join(",", list);
    }

//    private int findDivision(int[] preorder, int value, int low, int high){
//        int i;
//        for(i = low; i <= high; i++){
//            if(value < preorder[i])
//                break;
//        }
//        return i;
//    }
//
//    private TreeNode deserializeArray(int[] preorder, int low, int high){
//        if(low > high) return null;
//
//        TreeNode root = new TreeNode(preorder[low]);
//
//        int divIndex = findDivision(preorder, root.val, low+1, high);
//
//        root.left = deserializeArray(preorder, low+1, divIndex-1);
//        root.right = deserializeArray(preorder, divIndex, high);
//
//        return root;
//    }
}
