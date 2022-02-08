package com.infinite.publisher.aggregations;

public class Aggregator<T> {
	
	private String type;
	private T entity;
	
	public Aggregator(String type, T entity) {
		super();
		this.type = type;
		this.entity = entity;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
