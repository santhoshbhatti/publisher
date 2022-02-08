package com.infinite.publisher.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name = "lineitems")
public class LineItem {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	Order order;

	

	@Column(name = "purchaser_id")
	private Integer purchaserId;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name = "Total_Price")
	private Double totalPrize;

	public LineItem() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(Integer purchaserId) {
		this.purchaserId = purchaserId;
	}

	public Double getTotalPrize() {
		return totalPrize;
	}

	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}

	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}
