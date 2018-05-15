package org.ds.datastructures.graphs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph {

	private Set<WeightedVertex> vertices;
	public WeightedGraph() {
		
	}
	
	
	
	public void addVertex(WeightedVertex vertex) {
		vertices = ( vertices == null ) ? new HashSet<>() : vertices;
		vertices.add(vertex);
	}
	
	public void dijkstraAlgorithm(WeightedVertex start) {
		
		start.updateDistanceFromSourceAndVia(0, start);
		WeightedVertex current = start;

		while (current != null) {
			
			Map<WeightedVertex, Integer> nighours = current.getNighours();
			int currentNodeDistanceFromSource = current.getDistanceFromSource();
			WeightedVertex next = null;
			Integer minValue = null;
			if (nighours != null) {
				for (WeightedVertex v : nighours.keySet()) {

					Integer minDistance = currentNodeDistanceFromSource + nighours.get(v);
					if (minValue == null) {
						minValue = minDistance;
						next = v;
					} else {
						if (minValue > minDistance) {
							minValue = minDistance;
							next = v;
						}
					}

					if (minDistance < v.getDistanceFromSource()) {
						v.updateDistanceFromSourceAndVia(minDistance, current);
					}
				}
			}

			current = next;
		}
		
	}
	
	public static void main(String args[]) {
		
		WeightedGraph weightedGraph = new WeightedGraph();
		
		WeightedVertex a = new WeightedVertex("A");
		WeightedVertex b = new WeightedVertex("B");
		WeightedVertex c = new WeightedVertex("C");
		WeightedVertex d = new WeightedVertex("D");
		WeightedVertex e = new WeightedVertex("E");
		WeightedVertex f = new WeightedVertex("F");
		
		a.addNighour(b, 10);
		a.addNighour(c, 15);
		b.addNighour(d, 12);
		b.addNighour(f, 15);
		c.addNighour(e, 10);
		d.addNighour(e, 2);
		d.addNighour(f, 1);
		f.addNighour(e, 5);
		
		weightedGraph.addVertex(a);
		weightedGraph.addVertex(b);
		weightedGraph.addVertex(c);
		weightedGraph.addVertex(d);
		weightedGraph.addVertex(e);
		weightedGraph.addVertex(f);
		
	
		weightedGraph.dijkstraAlgorithm(a);
		
		
	}
}
