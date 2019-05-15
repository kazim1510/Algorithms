package com.algorithm.algorithm;

import org.junit.Before;
import org.junit.Test;

public class GraphsTest {

    private Graphs graphs;

    @Before
    public void setUp() throws Exception {
        graphs = new Graphs(8);
    }

    @Test
    public void bfs() {
        addGraph();
        System.out.println("BFS:");
        graphs.BFS(0);
    }

    @Test
    public void dfs() {
        addGraph();
        System.out.println("DFS:");
        graphs.DFS(0);
    }

    private void addGraph() {
        graphs.addEdge(0, 1);
        graphs.addEdge(0, 6);
        graphs.addEdge(0, 3);
        graphs.addEdge(1, 0);
        graphs.addEdge(1, 4);
        graphs.addEdge(1, 5);
        graphs.addEdge(4, 1);
        graphs.addEdge(4, 6);
        graphs.addEdge(6, 0);
        graphs.addEdge(6, 4);
        graphs.addEdge(3, 0);
        graphs.addEdge(3, 5);
        graphs.addEdge(5, 1);
        graphs.addEdge(5, 2);
        graphs.addEdge(5, 3);
        graphs.addEdge(2, 5);
        graphs.addEdge(2, 7);
        graphs.addEdge(7, 2);
    }
}
