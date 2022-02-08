package com.infinite.publisher.vos;

import java.util.Date;
import java.util.List;

public class OrderVo {
	
	private Integer orderId;
	private Date date;
	private Integer purchaserId;
	private Double totalPrize;
	private List<LineItemVo> lineitems;
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
	public Double getTotalPrize() {
		return totalPrize;
	}
	public void setTotalPrize(Double totalPrize) {
		this.totalPrize = totalPrize;
	}
	public List<LineItemVo> getLineitems() {
		return lineitems;
	}
	public void setLineitems(List<LineItemVo> lineitems) {
		this.lineitems = lineitems;
	}
	
	
	
}
