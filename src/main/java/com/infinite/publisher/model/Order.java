package com.infinite.publisher.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;

import javax.persistence.ForeignKey;



@Entity
@Table(name = "orders")
public class Order {
	
    @Id
    @GeneratedValue    
	@Column(name = "order_id")
    private Integer orderId;
    
    @Column(name = "order_date")
    private Date date;
    
    @Column(name = "purchaser_id")
    private Integer purchaserId;
    
    @OneToMany(mappedBy = "order", 
    		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
    	     CascadeType.REFRESH })
    private List<LineItem> lineitems;
    
    @Column(name = "total_price")
    private Double totalPrize;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(Integer purchaserId) {
		this.purchaserId = purchaserId;
	}

	public List<LineItem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(List<LineItem> lineitems) {
		this.lineitems = lineitems;
	}

	public Double getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	
	

	    
}

