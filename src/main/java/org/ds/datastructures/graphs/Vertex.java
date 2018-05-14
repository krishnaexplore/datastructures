package org.ds.datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

	private T data;
	private boolean visited;
	private List<Vertex<T>> edges;

	
	public Vertex(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isVisited() {
		return visited;
	}
	
	public void addEdge(Vertex<T> vertex) {
		if( edges == null)
			edges = new ArrayList<>();
		edges.add(vertex);
	}
	
	public List<Vertex<T>> getEdges(){
		return edges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex<T> other = (Vertex<T>) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
	
	
}
