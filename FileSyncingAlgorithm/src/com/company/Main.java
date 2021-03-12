package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<MarkleTree.Node> q = new LinkedList<>();
        q.add(new MarkleTree.Node("A"));
        q.add(new MarkleTree.Node("B"));
        q.add(new MarkleTree.Node("C"));
        q.add(new MarkleTree.Node("D"));
        q.add(new MarkleTree.Node("E"));

        MarkleTree mt = new MarkleTree();
        mt.buildTree(q);
        System.out.println("Root Hash of current data: " + mt.root.data);

        Queue<MarkleTree.Node> q2 = new LinkedList<>();
        q2.add(new MarkleTree.Node("AA"));
        q2.add(new MarkleTree.Node("B"));
        q2.add(new MarkleTree.Node("C"));
        q2.add(new MarkleTree.Node("D"));
        q2.add(new MarkleTree.Node("E"));
        MarkleTree mt2 = new MarkleTree();
        mt2.buildTree(q2);
        System.out.println("Root Hash of updated data: " + mt2.root.data);

        if(mt.detectChange(mt.root, mt2.root)){
            mt.root = mt.mergeChange(mt.root, mt2.root);
        }
    }
}
