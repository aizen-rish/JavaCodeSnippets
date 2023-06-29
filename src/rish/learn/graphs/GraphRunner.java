package rish.learn.graphs;

public class GraphRunner {

	public static void main(String[] args) {

		int V = 5;
		ListGraph graph1 = new ListGraph(V);

		graph1.addEdge(0, 1);
		graph1.addEdge(0, 4);
		graph1.addEdge(1, 2);
		graph1.addEdge(1, 3);
		graph1.addEdge(1, 4);
		graph1.addEdge(2, 3);
		graph1.addEdge(3, 4);

		graph1.printGraph();
	}

}
