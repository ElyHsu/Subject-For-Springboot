package com.foway.mason.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "coupon")
public class Coupon {
	@Id
	@Column(name = "coupon_serial_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couponserialnumber;
	@Column(name = "coupon_name")
	private String couponname;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "start_date")
	private Date startdate;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "end_date")
	private Date enddate;
	@Column(name = "refund_percent")
	private Float refundpercent;

	@Override
	public String toString() {
		Date date = new Date();
		SimpleDateFormat spl = new SimpleDateFormat("yyyy-MM-dd");
		String temp = spl.format(date);
		String temp2 = spl.format(date);
		try {
			date = spl.parse(temp);
			date = spl.parse(temp2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (startdate != null) {
			temp = spl.format(startdate);
		}
		if (enddate != null) {
			temp2 = spl.format(enddate);
		}

		return "Coupon [couponserialnumber=" + couponserialnumber + ", couponname=" + couponname + ", startdate=" + temp
				+ ", enddate=" + temp2 + ", refundpercent=" + refundpercent + "]";
	}

	public Coupon() {
	}

	public Coupon(Integer couponserialnumber, String couponname, Date startdate, Date enddate, Float refundpercent) {
		super();
		this.couponserialnumber = couponserialnumber;
		this.couponname = couponname;
		this.startdate = startdate;
		this.enddate = enddate;
		this.refundpercent = refundpercent;
	}

	public Integer getCouponserialnumber() {
		return couponserialnumber;
	}

	public void setCouponserialnumber(Integer couponserialnumber) {
		this.couponserialnumber = couponserialnumber;
	}

	public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Float getRefundpercent() {
		return refundpercent;
	}

	public void setRefundpercent(Float refundpercent) {
		this.refundpercent = refundpercent;
	}

}
