package com.zaki.WeightLengthAlgos;

public class ScheduleElement {
	private long weight;
	private long length;
	
	public ScheduleElement(long weight, long length) {
		this.weight = weight;
		this.length = length;
	}

	public long getWeightMinusLength() {
		return weight - length;
	}
	
	public double getWeightDivLength() {
		return  ((double)weight)/ ((double)length);
	}
	
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "ScheduleElement [weight=" + weight + ", length=" + length
				+ ", getWeightMinusLength()=" + getWeightMinusLength()
				+ ", getWeightDivLength()=" + getWeightDivLength() + "]";
	}
	
	
}
