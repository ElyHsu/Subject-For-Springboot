package com.foway.mason.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foway.mason.service.MailService;
import com.foway.mason.service.OrderMainFileService;
import com.foway.mason.vo.Cart;

@RestController
public class CartController {

	@Autowired
	OrderMainFileService orderMainFileHibernateService;
	@Autowired
	MailService mailService;
	
//訂單生成於資料庫區
	@PostMapping("CartServlet")
	public void cartfromhtml(@RequestBody Cart cart) {
//		System.out.println("couponname=" + cart.couponname); // 測試couponname接收
//		System.out.println("goldremaining=" + cart.goldremaining);// 測試購物金接收
//		System.out.println("carttotal=" + cart.carttotal);// 測試購物金接收

//		for (Cartlist cartlist : cart.cartlist) { // 測試商品接收(疊代用法)
//			System.out.println("cartobj=" + cartlist);
//		}

//		for (int i = 0; i < cart.itemlist.size(); i++) {     //一般用法
//			System.out.println("cartobj=" + cart.itemlist);
//
//		}
		//新增訂單主檔+訂單細項
		String orderresult = orderMainFileHibernateService.orderMaininsert(cart.couponname, cart, cart.itemlist,
				cart.carttotal);
		System.out.println("新增訂單主檔+訂單細項資料庫狀態=" + orderresult);
		
		//發送訂單成功郵件
		String mailsuc= mailService.mailtoclient();
		System.out.println(mailsuc);
		
	}

}
