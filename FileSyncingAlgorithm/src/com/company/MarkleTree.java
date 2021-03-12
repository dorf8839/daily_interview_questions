package com.company;

import org.w3c.dom.Node;

import java.util.Queue;
import java.util.zip.CRC32;

public class MarkleTree {
    public Node root;

    public static class Node{
        String data;
        Node left;
        Node right;

        Node(String value){
            data=value;
        }
    }

    public void buildTree(Queue<Node> q){
        while(q.size() > 1){
            int size = q.size();
            for(int i = 0; i < size; ){
                Node left = q.poll();
                i++;
                Node right = null;
                if(i < size) {
                    right = q.poll();
                    i++;
                }

                CRC32 crc = new CRC32();
                crc.update((left.data + ((right != null) ? right.data : "")).getBytes());
                Node parent = new Node(crc.getValue() + "");
                parent.left = left;
                parent.right = right;
                q.offer(parent);
            }
        }

        root = q.poll();
    }

    public boolean detectChange(Node refNode, Node newNode){
        if(refNode == null && newNode == null){
            return false;
        }
        if(refNode == null || newNode == null){
            System.out.println("Change detected. Change: data added/deleted");
            return true;
        }
        //Before printing the change, recurse to find the node that has changed
        boolean leftChanged = detectChange(refNode.left, newNode.left);
        boolean rightChanged = detectChange(refNode.right, newNode.right);
        if(refNode.data != newNode.data){
            System.out.println("Change in the data detected. RootHash of the change: " + newNode.data);
            return true;
        }
        return leftChanged || rightChanged;
    }

    public Node mergeChange(Node refNode, Node newNode){
        if(refNode == null && newNode == null){
            return null;
        }else if(refNode != null && newNode == null){
            System.out.println("Change detected. Change: data deleted");
            return null;
        }else if(refNode == null && newNode != null){
            System.out.println("Change detected. Change: data added");
            return newNode;
        }else if(refNode.data != newNode.data){
            refNode.data = newNode.data;
        }
        //Before printing the change, recurse to find the node that has changed
        refNode.left = mergeChange(refNode.left, newNode.left);
        refNode.right = mergeChange(refNode.right, newNode.right);

        return refNode;
    }
}
