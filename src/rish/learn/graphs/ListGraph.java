package rish.learn.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ListGraph {

    private List<List<Integer>> graph;
    private boolean isBiDirectional;

    public ListGraph(int size) {
        this.isBiDirectional = true;
        this.graph = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public ListGraph(int size, boolean isBiDirectional) {
        this.isBiDirectional = isBiDirectional;
        this.graph = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        graph.get(from).add(to);
        if (isBiDirectional) {
            graph.get(to).add(from);
        }
    }

    public void printGraph() {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " (head)");
            for (int j : graph.get(i)) {
                System.out.print(" -> " + j);
            }
            System.out.println();
        }
    }

    public void bfsTraversal() {

        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                bfsTraversalInternal(i, visited);
            }
        }
    }

    public void bfsTraversal(int start) {
        boolean[] visited = new boolean[graph.size()];
        bfsTraversalInternal(start, visited);
    }

    public void bfsTraversalInternal(int start, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int vis = queue.remove();
            System.out.print(vis + " ");

            for (int node : graph.get(vis)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    public void dfsTraversal() {

        boolean[] visited = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfsTraversalInternal(i, visited);
            }
        }
    }

    public void dfsTraversal(int start) {
        boolean[] visited = new boolean[graph.size()];
        dfsTraversalInternal(start, visited);
    }

    public void dfsTraversalInternal(int start, boolean[] visited) {

        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        visited[start] = true;

        while (!stack.isEmpty()) {

            Integer vis = stack.pop();
            System.out.print(vis + " ");

            for (int node : graph.get(vis)) {
                if (!visited[node]) {
                    visited[node] = true;
                    stack.add(node);
                }
            }
        }
    }

    public void topologicalTraversal() {

        if (isBiDirectional) {
            return;
        }

        int[] indegrees = new int[graph.size()];
        for (List<Integer> row : graph) {
            for (int node : row) {
                indegrees[node]++;
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

            for (int node : graph.get(vis)) {
                indegrees[node]--;
                if (indegrees[node] == 0) {
                    zeroIndegreeNodes.add(node);
                }
            }

            visitedNodeCount++;
        }

        if (visitedNodeCount != graph.size()) {
            System.out.println("Graph has a cycle: " + visitedNodeCount);
        }
    }

}
