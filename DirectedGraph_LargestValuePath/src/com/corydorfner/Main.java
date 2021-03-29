package com.corydorfner;

import java.util.*;

public class Main {

    private static final int VISITED = 0;
    private static final int UNVISITED = 1;
    private static final int VISITING = 2;

    public static void main(String[] args) {
	    String s = "ABACA";
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
//        String s = "A";
//        int[][] edges = {{0,0}};
        System.out.println(maxGraphPath(s, edges));
    }

    public static int maxGraphPath(String s, int[][] edges){
        Map<Integer, List<Integer>> graph = constructGraph(s, edges);
        int[] states = new int[s.length()];
        Arrays.fill(states, UNVISITED);
        int[][] maxPaths = new int[s.length()][26];

        for(int node = 0; node < s.length(); node++){
            if(states[node] == UNVISITED){
                if(dfs(s, graph, states, maxPaths, node)){
                    return Integer.MAX_VALUE;
                }
            }
        }
        int maxPathValue = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 26; j++){
                maxPathValue = Math.max(maxPaths[i][j], maxPathValue);
            }
        }
        return maxPathValue;
    }

    private static Map<Integer, List<Integer>> constructGraph(String s, int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        return graph;
    }

    private static boolean dfs(String s, Map<Integer, List<Integer>> graph, int[] states, int[][] maxPaths, int node){
        if(states[node] == VISITED){
            return false;
        }else if(states[node] == VISITING){
            return true;
        }
        states[node] = VISITING;
        for(int neighbor : graph.get(node)){
            dfs(s, graph, states, maxPaths, neighbor);
        }
        for(int neighbor : graph.get(node)){
            for(int letter = 0; letter < s.length(); letter++){
                int currentLetter = s.charAt(letter) - 'A';
                maxPaths[node][currentLetter] = Math.max(maxPaths[node][currentLetter], maxPaths[neighbor][currentLetter]);
            }
        }
        maxPaths[node][s.charAt(node) - 'A']++;
        states[node] = VISITED;
        return false;
    }
}
