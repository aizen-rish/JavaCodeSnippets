package rish.learn.graphs;

import java.util.ArrayList;
import java.util.List;

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

	public void addEdge(int from, int to) {
		graph.get(from).add(to);
		if (isBiDirectional) {
			graph.get(to).add(from);
		}
	}

	public void printGraph() {
		for (int i = 0; i < graph.size(); i++) {
			System.out.print(i + " (head)");
			List<Integer> vertexList = graph.get(i);
			for (int j = 0; j < vertexList.size(); j++) {
				System.out.print(" -> " + vertexList.get(j));
			}
			System.out.println();
		}
	}

}
