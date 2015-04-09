package com.zaki.KruskalAlgorithm;

import java.util.Set;

public class UnionFind<V> {
	private Set<UnionFindNode<V>> allNodes; 
	
	public void createSet(V value) {
		UnionFindNode<V> node = new UnionFindNode<V>(value, null, 0);
		node.setParent(node);
		allNodes.add(node);
	}
	
	public void union(V x, V y) {
		UnionFindNode<V> rootX = findForValue(x);
		UnionFindNode<V> rootY = findForValue(y);
		
		if (rootX.equals(rootY)) {
			return;
		}
		
		if (rootX.getRank() < rootY.getRank()) {
			rootX.setParent(rootY);
		}
		else if (rootY.getRank() < rootX.getRank()) {
			rootY.setParent(rootX);
		} else {
			rootY.setParent(rootX);
			rootX.setRank(rootX.getRank()+1);
		}
		
	}
	
	private UnionFindNode<V> findForValue(V value) {
		UnionFindNode<V> node = getNodeForValue(value);
		return find (node);
	}
	
	private UnionFindNode<V> getNodeForValue(V value) {
		for (UnionFindNode<V> node : allNodes) {
			if (node.getValue().equals(value)) {
				return node;
			}
		}		
		return null;
	}
	
	public UnionFindNode<V> find(UnionFindNode<V> node) {
		if (node == null) {
			return null;
		}
		
		while (!node.getParent().equals(node)) {
			node.setParent(find(node.getParent()));
		}
		
		return node.getParent();		
	}
	
	public void initialize(Set<V> allNodes) {
		for (V v : allNodes) {
			createSet(v);
		}
	}
}	
