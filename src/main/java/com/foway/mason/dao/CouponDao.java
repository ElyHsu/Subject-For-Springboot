package com.foway.mason.dao;

import java.util.List;

import com.foway.mason.vo.Coupon;

public interface CouponDao {
	Coupon insert(Coupon coupon);

	Coupon update(Coupon coupon);

	boolean remove(Integer couponserialnumber);

	Integer selectcouponserialnumber(String couponname);

	List<Coupon> selectall();

	Coupon selectone(Coupon coupon);

	String selectcouponname(String couponname);

	Float selectcouporefundpercent(String couponname);

	Float selectbyCouponId(Integer couponserialnumber);

}