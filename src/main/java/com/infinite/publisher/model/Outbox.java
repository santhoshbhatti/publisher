package com.infinite.publisher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "outbox")
public class Outbox {
	@Id
    @GeneratedValue    
	@Column(name = "outbox_id")
	private Integer id;
	@Column(name = "agg_type")
	private String type;
	@Column(name = "entity",columnDefinition = "text(65535)") 
	private String entity;
	@Column(name = "eventName")
	private String eventName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


