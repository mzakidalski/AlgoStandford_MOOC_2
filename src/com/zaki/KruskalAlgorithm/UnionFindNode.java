package com.zaki.KruskalAlgorithm;

public class UnionFindNode<V> {
	private V value;
	private UnionFindNode parent;
	int rank;
	
	public UnionFindNode(V value, UnionFindNode<V> parent, int rank) {
		this.value = value;
		this.parent = parent;
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		UnionFindNode other = (UnionFindNode) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public UnionFindNode getParent() {
		return parent;
	}

	public void setParent(UnionFindNode parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

}
