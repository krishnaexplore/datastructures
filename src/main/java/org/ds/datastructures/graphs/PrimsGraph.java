package org.ds.datastructures.graphs;

public class PrimsGraph {

	private int v;
	private int[] vertices;
	private int[][] adjMatrix;
	private int size;
	public PrimsGraph(int noOfVertices) {
		this.v = noOfVertices;
		vertices = new int[v];
		adjMatrix = new int[v][v];
		size = 0;
	}
	
	public void addVertex(int vertex) {
		vertices[size++] = vertex;
	}
	public void addEdge(int src, int dest, int weight) {
		adjMatrix[src][dest] = weight;
		adjMatrix[dest][src] = weight;
	}
	
	public void primsAlgo() {
		for(int i=0; i<v;i++) {
			
		}
	}
	public void printGraph() {
		
		
		for(int i=0; i< v; i++) {
			for( int j=0; j<v; j++) {
				System.out.print(adjMatrix[i][j] + ", ");
			}
			System.out.println();
		}
		
	}
	public static void main(String args[]) {
		
		PrimsGraph primsGraph = new PrimsGraph(9);
		primsGraph.addVertex(0);
		primsGraph.addVertex(1);
		primsGraph.addVertex(2);
		primsGraph.addVertex(3);
		primsGraph.addVertex(4);
		primsGraph.addVertex(5);
		primsGraph.addVertex(6);
		primsGraph.addVertex(7);
		primsGraph.addVertex(8);
		
		primsGraph.addEdge(0, 1, 4);
		primsGraph.addEdge(0, 7, 8);
		primsGraph.addEdge(1, 2, 8);
		primsGraph.addEdge(1, 7, 11);
		primsGraph.addEdge(2, 3, 7);
		primsGraph.addEdge(2, 5, 4);
		primsGraph.addEdge(2, 8, 2);
		primsGraph.addEdge(3, 4, 9);
		primsGraph.addEdge(3, 5, 14);
		primsGraph.addEdge(4, 5, 10);
		primsGraph.addEdge(5, 6, 2);
		primsGraph.addEdge(6, 7, 1);
		primsGraph.addEdge(6, 8, 6);
		primsGraph.addEdge(7, 8, 7);
		
		primsGraph.printGraph();
	}
}
