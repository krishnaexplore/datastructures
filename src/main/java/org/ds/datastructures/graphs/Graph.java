package org.ds.datastructures.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Graph<T> {

	private Vertex<T> vertices[];
	
	
	public Graph(Vertex<T> vertices[]) {
		this.vertices = vertices;
	}
	
	public void addEdge(Vertex<T> start, Vertex<T> end) {
	   for(int i = 0 ; i< vertices.length;i++) {
		   if( vertices[i].equals(start) ) {
			   vertices[i].addEdge(end);
			   break;
		   }
	   }
	}
	
	public Vertex<T>[] getVertices(){
		return vertices;
	}
	
	public void dfsIterative(Vertex<T> start) {
		if( start == null)
			return;
		Stack<Vertex<T>> stack = new Stack<>();
		stack.push(start);
		while (!stack.isEmpty()) {
			Vertex<T> item = stack.pop();
			if (!item.isVisited()) {
				System.out.print(item.getData() + ", ");
				item.setVisited(true);
				if (item.getEdges() != null) {
					Iterator<Vertex<T>> i = item.getEdges().iterator();
					while (i.hasNext()) {
						stack.push(i.next());
					}
				}
			}
		}

	}
	
	public void dfsRecursive(Vertex<T> start) {
		
		if(start == null)
			return;
		if(!start.isVisited()) {
			System.out.print(start.getData() +", ");
			start.setVisited(true);
			List<Vertex<T>> edgs = start.getEdges();
			if(edgs!=null) {
				Iterator<Vertex<T>> i = edgs.iterator();
				while(i.hasNext()) {
					dfsRecursive(i.next());
				}
			}
		}
	}
	
	public void bfsIterative(Vertex<T> start) {
		if( start == null)
			return;
		
		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.offer( start );
		while(!queue.isEmpty()) {
			Vertex<T> item = queue.poll();
			if(!item.isVisited()) {
				System.out.print(item.getData() + ",");
				item.setVisited(true);
				List<Vertex<T>> nighours = item.getEdges();
				if(nighours!=null) {
					ListIterator<Vertex<T>> itr = nighours.listIterator();
					while( itr.hasNext()) {
						queue.offer( itr.next() );
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		/**
		 *     0---------------->1
		 *     |                /
		 *     |             /
		 *     |            /
		 *     |          /
		 *     v       /
		 *     2                3
		 */
		
		
		int numberVertices = 4;
		Vertex<Integer> v1 = new Vertex<>(0);
		Vertex<Integer> v2 = new Vertex<>(1);
		Vertex<Integer> v3 = new Vertex<>(2);
		Vertex<Integer> v4 = new Vertex<>(3);
		Vertex<Integer> vertices[] =new Vertex[numberVertices];
		vertices[0] = v1;
		vertices[1] = v2;
		vertices[2] = v3;
		vertices[3] = v4;
		Graph<Integer> graph = new Graph<>( vertices );
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v2, v3);
		graph.addEdge(v3, v1);
		graph.addEdge(v3, v4);
		graph.addEdge(v4, v4);
		
		
		
		//graph.dfsIterative(v3);
		//graph.dfsRecursive(v3);
		//graph.bfsIterative(v3);
		
		System.out.println(   "Is Cycle Exists     " +graph.isCycleExistsInDirectedGraph( v1 ) );
	}
	
	public boolean isCycleExistsInDirectedGraph(Vertex<T> source) {
		
		Stack<Vertex<T>> stack = new Stack<>();
		stack.push( source );
		while( !stack.isEmpty() ) {
			
			Vertex<T> item = stack.pop();
			if( item.isVisited( ) )
				return true;
			
			item.setVisited( true );
			List<Vertex<T>> nighours = item.getEdges();
			
			if( nighours != null ) {
				ListIterator<Vertex<T>> lt = nighours.listIterator();
				while(lt.hasNext()) {
					stack.push( lt.next() );
				}
			}
		}
		return false;
	}
	
	
	
}
