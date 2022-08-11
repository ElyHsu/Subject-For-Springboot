package com.foway.mason.vo;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_main_file")
public class OrderMainFile implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_serial_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderserialnumber;
	@Column(name = "member_serial_number")
	private Integer memberserialnumber;
	@Column(name = "seller_serial_number")
	private Integer sellerserialnumber;
	@Column(name = "order_status_number")
	private String orderstatusnumber;
	@Column(name = "coupon_serial_number")
	private Integer couponserialnumber;
	@Column(name = "seller_evaluation_star")
	private Integer sellerevaluationstar;
	@Column(name = "member_evaluation_star")
	private Integer memberevaluationstar;
	@Column(name = "seller_evaluation_description")
	private String sellerevaluationdescription;
	@Column(name = "member_evaluation_description")
	private String memberevaluationdescription;
	@Column(name = "member_evaluation_photo")
	private byte[] memberevaluationphoto;
	@Column(name = "order_amount")
	private Integer orderamount;
	@Column(name = "order_date")
	private Date orderdate;
	@Override
	public String toString() {
		Date date = new Date();
		SimpleDateFormat spl = new SimpleDateFormat("yyyy-MM-dd");
		String temp = spl.format(date);
		try {
			date = spl.parse(temp);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (orderdate != null) {
			temp = spl.format(orderdate);
		}
		return "OrderMainFile [orderserialnumber=" + orderserialnumber + ", memberserialnumber=" + memberserialnumber
				+ ", sellerserialnumber=" + sellerserialnumber + ", orderstatusnumber=" + orderstatusnumber
				+ ", couponserialnumber=" + couponserialnumber + ", sellerevaluationstar=" + sellerevaluationstar
				+ ", memberevaluationstar=" + memberevaluationstar + ", sellerevaluationdescription="
				+ sellerevaluationdescription + ", memberevaluationdescription=" + memberevaluationdescription
				+ ", memberevaluationphoto=" + Arrays.toString(memberevaluationphoto) + ", orderamount=" + orderamount
				+ ", orderdate=" + orderdate + "]";
	}

	
	
	public OrderMainFile(Integer orderserialnumber, Integer memberserialnumber, Integer sellerserialnumber,
			String orderstatusnumber, Integer couponserialnumber, Integer sellerevaluationstar,
			Integer memberevaluationstar, String sellerevaluationdescription, String memberevaluationdescription,
			byte[] memberevaluationphoto, Integer orderamount, Date orderdate) {
		super();
		this.orderserialnumber = orderserialnumber;
		this.memberserialnumber = memberserialnumber;
		this.sellerserialnumber = sellerserialnumber;
		this.orderstatusnumber = orderstatusnumber;
		this.couponserialnumber = couponserialnumber;
		this.sellerevaluationstar = sellerevaluationstar;
		this.memberevaluationstar = memberevaluationstar;
		this.sellerevaluationdescription = sellerevaluationdescription;
		this.memberevaluationdescription = memberevaluationdescription;
		this.memberevaluationphoto = memberevaluationphoto;
		this.orderamount = orderamount;
		this.orderdate = orderdate;
	}



	public OrderMainFile() {
	}

	public Integer getOrderserialnumber() {
		return orderserialnumber;
	}

	public void setOrderserialnumber(Integer orderserialnumber) {
		this.orderserialnumber = orderserialnumber;
	}

	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}

	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}

	public Integer getSellerserialnumber() {
		return sellerserialnumber;
	}

	public void setSellerserialnumber(Integer sellerserialnumber) {
		this.sellerserialnumber = sellerserialnumber;
	}

	public String getOrderstatusnumber() {
		return orderstatusnumber;
	}

	public void setOrderstatusnumber(String orderstatusnumber) {
		this.orderstatusnumber = orderstatusnumber;
	}

	public Integer getCouponserialnumber() {
		return couponserialnumber;
	}

	public void setCouponserialnumber(Integer couponserialnumber) {
		this.couponserialnumber = couponserialnumber;
	}

	public Integer getSellerevaluationstar() {
		return sellerevaluationstar;
	}

	public void setSellerevaluationstar(Integer sellerevaluationstar) {
		this.sellerevaluationstar = sellerevaluationstar;
	}

	public Integer getMemberevaluationstar() {
		return memberevaluationstar;
	}

	public void setMemberevaluationstar(Integer memberevaluationstar) {
		this.memberevaluationstar = memberevaluationstar;
	}

	public String getSellerevaluationdescription() {
		return sellerevaluationdescription;
	}

	public void setSellerevaluationdescription(String sellerevaluationdescription) {
		this.sellerevaluationdescription = sellerevaluationdescription;
	}

	public String getMemberevaluationdescription() {
		return memberevaluationdescription;
	}

	public void setMemberevaluationdescription(String memberevaluationdescription) {
		this.memberevaluationdescription = memberevaluationdescription;
	}

	public byte[] getMemberevaluationphoto() {
		return memberevaluationphoto;
	}

	public void setMemberevaluationphoto(byte[] memberevaluationphoto) {
		this.memberevaluationphoto = memberevaluationphoto;
	}

	public Integer getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(Integer orderamount) {
		this.orderamount = orderamount;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
}