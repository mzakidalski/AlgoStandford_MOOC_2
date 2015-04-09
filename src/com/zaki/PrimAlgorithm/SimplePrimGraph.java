package com.zaki.PrimAlgorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SimplePrimGraph {
	private SimpleVertex[] allVertices;
	private Set<SimpleVertex> visitedVertices = new HashSet<>();
	private List<SimpleEdge> edgesInMST = new LinkedList<>();
	private long minimumTreeLength;
	private int size;
	
	public SimplePrimGraph(int size) {
		this.size = size;
		allVertices = new SimpleVertex[this.size+1];
		for (int i=1; i<= size; ++i) {
			SimpleVertex v = new SimpleVertex(i);
			allVertices[i] = v;
		}
	}
	
	public int getSize() {
		return size;
	}

	private void addSingleEdge(int first, int second, long weight) {
		SimpleEdge edgeToAdd = new SimpleEdge(first, second, weight);
		SimpleVertex firstVertex = allVertices[first];
		firstVertex.addEdge(edgeToAdd);		
	}
	
	public void addEdge(int first, int second, long weight) {
		addSingleEdge(first, second, weight);
		addSingleEdge(second, first, weight);
	}
	
	private SimpleEdge getMinimumCrossingEdge() {		
		SimpleEdge result = SimpleEdge.getEdgeWithMaximumWeight();		
		for (SimpleVertex firstVertex : this.visitedVertices) {
			for (SimpleEdge edge : firstVertex.getOutboundEdges()) {
				SimpleVertex secondVertex = allVertices[edge.getSecond()];
				if (!visitedVertices.contains(secondVertex) && edge.getWeight() < result.getWeight()) {
					result = edge;
				}
			}
		}
		return result;
	}

	public long getMinSpanningTree(int startIndex) {
		visitedVertices.clear();
		edgesInMST.clear();
		minimumTreeLength = 0;
		
		visitedVertices.add(allVertices[startIndex]);
		
		while (visitedVertices.size() != size) {
			SimpleEdge crossEdge = getMinimumCrossingEdge();
			edgesInMST.add(crossEdge);
			minimumTreeLength += crossEdge.getWeight();
			SimpleVertex secondVertex = allVertices[crossEdge.getSecond()];
			visitedVertices.add(secondVertex);
		}
		
		return minimumTreeLength;
	}

	
	public List<SimpleEdge> getEdgesInMST() {
		return edgesInMST;
	}
	
	public long getMinimumTreeLength() {
		return minimumTreeLength;
	}


}
