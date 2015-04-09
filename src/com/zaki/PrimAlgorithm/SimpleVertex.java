package com.zaki.PrimAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleVertex {
	private int id;
	List<SimpleEdge> outboundEdges;
	
	public int getId() {
		return id;
	}

	public List<SimpleEdge> getOutboundEdges() {
		return Collections.unmodifiableList(outboundEdges);
	}

	public SimpleVertex(int id) {
		this.id = id;
		this.outboundEdges = new ArrayList<SimpleEdge>();
	}
	
	public void addEdge(SimpleEdge edge) {
		this.outboundEdges.add(edge);		
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		SimpleVertex other = (SimpleVertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
