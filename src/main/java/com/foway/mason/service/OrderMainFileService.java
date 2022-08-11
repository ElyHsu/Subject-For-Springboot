package com.foway.mason.service;

import java.util.List;

import com.foway.mason.vo.Cart;
import com.foway.mason.vo.Itemlist;

public interface OrderMainFileService {
	
	String orderMaininsert(String couponname, Cart cart, List<Itemlist> itemlist, Integer carttotal);
	
}