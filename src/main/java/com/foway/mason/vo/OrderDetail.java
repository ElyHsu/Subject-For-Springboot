package com.foway.mason.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@Column(name = "order_detail_serial_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderdetailserialnumber;
	
	@Column(name = "order_serial_number")
	private Integer orderserialnumber;
	
	@Column(name = "item_serial_number")
	private Integer itemserialnumber;
	
	@Column(name = "order_detail_price")
	private Integer orderdetailprice;
	
	@Column(name = "order_detail_quantity")
	private Integer orderdetailquantity;
	
	@Column(name = "refund_reason")
	private String refundreason;
	
	@Column(name = "order_detail_status")
	private Integer orderdetailstatus;

	@Override
	public String toString() {
		return "OrderDetail [orderdetailserialnumber=" + orderdetailserialnumber + ", orderserialnumber="
				+ orderserialnumber + ", itemserialnumber=" + itemserialnumber + ", orderdetailprice="
				+ orderdetailprice + ", orderdetailquantity=" + orderdetailquantity + ", refundreason=" + refundreason
				+ ", orderdetailstatus=" + orderdetailstatus + "]";
	}

	public Integer getOrderdetailserialnumber() {
		return orderdetailserialnumber;
	}

	public void setOrderdetailserialnumber(Integer orderdetailserialnumber) {
		this.orderdetailserialnumber = orderdetailserialnumber;
	}

	public Integer getOrderserialnumber() {
		return orderserialnumber;
	}

	public void setOrderserialnumber(Integer orderserialnumber) {
		this.orderserialnumber = orderserialnumber;
	}

	public Integer getItemserialnumber() {
		return itemserialnumber;
	}

	public void setItemserialnumber(Integer itemserialnumber) {
		this.itemserialnumber = itemserialnumber;
	}

	public Integer getOrderdetailprice() {
		return orderdetailprice;
	}

	public void setOrderdetailprice(Integer orderdetailprice) {
		this.orderdetailprice = orderdetailprice;
	}

	public Integer getOrderdetailquantity() {
		return orderdetailquantity;
	}

	public void setOrderdetailquantity(Integer orderdetailquantity) {
		this.orderdetailquantity = orderdetailquantity;
	}

	public String getRefundreason() {
		return refundreason;
	}

	public void setRefundreason(String refundreason) {
		this.refundreason = refundreason;
	}

	public Integer getOrderdetailstatus() {
		return orderdetailstatus;
	}

	public void setOrderdetailstatus(Integer orderdetailstatus) {
		this.orderdetailstatus = orderdetailstatus;
	}
}
