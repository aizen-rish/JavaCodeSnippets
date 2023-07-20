package rish.learn.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MatrixGraph {

    private int[][] graph;
    private boolean isBiDirectional;

    public MatrixGraph(int size, boolean isBiDirectional) {
        this.graph = new int[size][size];
        this.isBiDirectional = isBiDirectional;
    }

    public MatrixGraph(int[][] graph, boolean isBiDirectional) {
        this.graph = graph;
        this.isBiDirectional = isBiDirectional;
    }

    public void addEdge(int from, int to) {
        graph[from][to] = 1;
        if (isBiDirectional) {
            graph[to][from] = 1;
        }
    }

    public void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " (head)");
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(" | " + graph[i][j]);
            }
            System.out.println();
        }
    }

    public void bfsTraversal() {

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                bfsTraversalInternal(i, visited);
            }
        }
    }

    public void bfsTraversal(int start) {
        boolean[] visited = new boolean[graph.length];
        bfsTraversalInternal(start, visited);
    }

    private void bfsTraversalInternal(int start, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int vis = queue.remove();
            System.out.print(vis + " ");

            for (int i = 0; i < graph[vis].length; i++) {
                if (graph[vis][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void dfsTraversal() {

        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfsTraversalInternal(i, visited);
            }
        }
    }

    public void dfsTraversal(int start) {
        boolean[] visited = new boolean[graph.length];
        dfsTraversalInternal(start, visited);
    }

    public void dfsTraversalInternal(int start, boolean[] visited) {

        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

        while (!stack.isEmpty()) {

            int vis = stack.pop();
            System.out.print(vis + " ");

            for (int i = 0; i < graph[vis].length; i++) {
                if (graph[vis][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.add(i);
                }
            }
        }
    }

    public void topologicalTraversal() {

        if (isBiDirectional) {
            return;
        }

        int[] indegrees = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    indegrees[j]++;
                }
            }
        }

        Queue<Integer> zeroIndegreeNodes = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                zeroIndegreeNodes.add(i);
            }
        }

        int visitedNodeCount = 0;

        while (!zeroIndegreeNodes.isEmpty()) {

            Integer vis = zeroIndegreeNodes.remove();
            System.out.print(vis + " ");

            for (int j = 0; j < graph[vis].length; j++) {

                if (graph[vis][j] == 0) {
                    continue;
                }

                indegrees[j]--;
                if (indegrees[j] == 0) {
                    zeroIndegreeNodes.add(j);
                }
            }
            visitedNodeCount++;
        }

        if (visitedNodeCount != graph.length) {
            System.out.println("Graph has a cycle: " + visitedNodeCount);
        }
    }

}
