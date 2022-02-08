package com.infinite.publisher.vos;

public class LineItemVo {
	
	private Integer id;
	private Integer orderId;
	private String itemName;
	private Integer purchaserId;
	private Double totalPrize;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	
	
}
