package com.algorithm.algorithm;


import java.util.Iterator;
import java.util.LinkedList;

import com.algorithm.datastructure.Queue;
import com.algorithm.datastructure.Stack;

public class Graphs {
    private Integer V;
    private LinkedList adj[];

    public Graphs(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[V];
        Queue queue = new Queue();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.remove();
            System.out.println(s + " ");
            Iterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {
                Integer n = iterator.next();
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        Stack stack = new Stack();
        visited[s] = true;
        stack.push(s);

        while (stack.size() != 0) {
            s = stack.pop();
            System.out.println(s + " ");
            Iterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {
                Integer n = iterator.next();
                if (!visited[n]) {
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }
    }
}
