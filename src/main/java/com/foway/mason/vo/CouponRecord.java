package com.foway.mason.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon_record")
public class CouponRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "coupon_serial_number")
	private Integer couponserialnumber;

	@Id
	@Column(name = "member_serial_number")
	private Integer memberserialnumber;
	
	@Column(name = "coupon_record_status")
	private Integer couponrecordstatus;

	public CouponRecord() {

	}

	@Override
	public String toString() {
		return "CouponRecord [couponserialnumber=" + couponserialnumber + ", memberserialnumber=" + memberserialnumber
				+ ", couponrecordstatus=" + couponrecordstatus + "]";
	}

	public Integer getCouponserialnumber() {
		return couponserialnumber;
	}

	public void setCouponserialnumber(Integer couponserialnumber) {
		this.couponserialnumber = couponserialnumber;
	}

	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}

	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}

	public Integer getCouponrecordstatus() {
		return couponrecordstatus;
	}

	public void setCouponrecordstatus(Integer couponrecordstatus) {
		this.couponrecordstatus = couponrecordstatus;
	}

}
