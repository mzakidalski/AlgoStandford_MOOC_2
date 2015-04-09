package com.zaki.PrimAlgorithm;

public class SimpleEdge {

	private int first;
	private int second;
	private long weight;
	
	public SimpleEdge(int first, int second, long weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}
	
	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	public long getWeight() {
		return weight;
	}

	public static SimpleEdge getEdgeWithMaximumWeight() {
		return new SimpleEdge(0,0, Long.MAX_VALUE);
	}
	
	@Override
	public String toString() {
		return "SimpleEdge [first=" + first + ", second=" + second
				+ ", weight=" + weight + "]";
	}


}
