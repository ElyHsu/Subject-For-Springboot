package com.foway.mason.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foway.mason.dao.CouponDao;
import com.foway.mason.service.CouponService;
import com.foway.mason.vo.Coupon;

@RestController
public class CouponController {

	@Autowired
	private CouponService couponService;
	@Autowired
	private CouponDao couponDao;

	@PostMapping("Coupon")
	public Map<String, Object> couponinsert(@RequestBody Coupon coupon) {
		final String errMsg = couponService.newcoupon(coupon);
		Map<String, Object> errMsgMap = new HashMap<>();
		errMsgMap.put("errMsg", errMsg);
		return errMsgMap;
	}

	@PostMapping("CouponSelect")
	public Coupon couponselect(@RequestBody Coupon coupon){
		Coupon resS =couponDao.selectone(coupon);
		return resS;
	}
	
	@GetMapping("Coupon")
	public List<Coupon> couponselctall() {
		List<Coupon>couponlist=couponDao.selectall();
		return couponlist;
	}
}
