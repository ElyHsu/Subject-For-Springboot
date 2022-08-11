package com.foway.mason.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foway.mason.service.GoldRemainingCheckService;
import com.foway.mason.vo.Member;

@RestController
public class GoldRemainingCheckController {

	@Autowired
	GoldRemainingCheckService goldRemainingCheckService;

	@PostMapping("/GoldRemainingCheck")
	public Map<String, Object> goldremainingcheck(@RequestBody Member memberHibernate) {
		final String Msg = goldRemainingCheckService.CouponverifyGoldRemaining(memberHibernate.getGoldremaining()); // 傳入之參數交給couponVerifyService處理
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("Msg", Msg);
		return resMap;
	}
}
