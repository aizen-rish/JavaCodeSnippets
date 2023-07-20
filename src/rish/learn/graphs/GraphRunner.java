package rish.learn.graphs;

public class GraphRunner {

    public static void main(String[] args) {

        int V = 5;
        ListGraph graph1 = new ListGraph(V, false);

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 4);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(1, 4);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);

        graph1.printGraph();
        graph1.bfsTraversal(0);
        graph1.dfsTraversal(0);
        graph1.topologicalTraversal();

        MatrixGraph graph2 = new MatrixGraph(V, false);

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 4);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);

        graph2.printGraph();
        graph2.bfsTraversal(0);
        graph2.dfsTraversal(0);
        graph2.topologicalTraversal();
    }

}
