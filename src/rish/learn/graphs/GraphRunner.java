package rish.learn.graphs;

public class GraphRunner {

    public static void main(String[] args) {

        int V = 7;
        ListGraph graph1 = new ListGraph(V, false);

        graph1.addEdge(0, 1);
        graph1.addEdge(0, 4);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(1, 4);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(5, 6);

        graph1.printGraph();
        graph1.bfsTraversal();
        graph1.dfsTraversal();
        graph1.topologicalTraversal();

        MatrixGraph graph2 = new MatrixGraph(V, false);

        graph2.addEdge(0, 1);
        graph2.addEdge(0, 4);
        graph2.addEdge(1, 2);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 4);
        graph2.addEdge(5, 6);

        graph2.printGraph();
        graph2.bfsTraversal();
        graph2.dfsTraversal();
        graph2.topologicalTraversal();
    }

}
