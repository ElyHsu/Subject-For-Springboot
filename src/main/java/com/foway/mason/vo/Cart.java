package com.foway.mason.vo;

import java.util.List;

public class Cart {
	public List<Itemlist> itemlist;
	public String couponname;
	public Integer goldremaining;
	public Integer carttotal;
	
	@Override
	public String toString() {
		return "Cart [itemlist=" + itemlist + ", couponname=" + couponname + ", goldremaining=" + goldremaining
				+ ", carttotal=" + carttotal + "]";
	}
}
