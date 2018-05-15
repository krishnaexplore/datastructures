package org.ds.datastructures.graphs;

import java.util.HashMap;
import java.util.Map;

public class WeightedVertex {

	private String label;
	private Map<WeightedVertex, Integer> nighours;
	private Integer distanceFromSource;
	private WeightedVertex via;
	public WeightedVertex(String label) {
		this.label = label;
		distanceFromSource = Integer.MAX_VALUE;
	}
	
	public void addNighour(WeightedVertex nighour, Integer distance) {
		nighours = nighours == null ? new HashMap<>() : nighours;
		this.nighours.put(nighour, distance);
	}
	
	public Map<WeightedVertex,Integer> getNighours(){
		return nighours;
	}
	
	public Integer getDistanceFromSource() {
		return distanceFromSource;
	}
	public WeightedVertex getVia() {
		return via;
	}
	
	public void updateDistanceFromSourceAndVia(Integer distanceFromSource, WeightedVertex v) {
		this.distanceFromSource = distanceFromSource;
		via = v;
	}

	
	@Override
	public String toString() {
		return label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		WeightedVertex other = (WeightedVertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	
	
}
