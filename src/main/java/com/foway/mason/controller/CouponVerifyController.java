package com.foway.mason.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foway.mason.service.CouponVerifyService;
import com.foway.mason.vo.Coupon;

@RestController
public class CouponVerifyController {
	@Autowired
	private CouponVerifyService couponVerifyService;
	
	@PostMapping("/CouponVerify")
	public Map<String, Object> couponVerify(@RequestBody Coupon coupon) {
		final String Msg = couponVerifyService.Couponverify(coupon.getCouponname());
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("Msg", Msg);
		if (Msg.equals("使用Coupon券成功，本次回饋數為"
				+ String.valueOf(couponVerifyService.Couponrefundpercent(coupon.getCouponname())))) {
			String couponnamestr = couponVerifyService.Couponnamestr(coupon.getCouponname());
			resMap.put("couponnamejstr", couponnamestr);
		}
		return resMap;
	}
}
