package com.foway.mason.vo;

public class Itemlist {
	public Integer itemserialnumber;
	public Integer itemquantity;
	public Integer itemprice;
	public String itemname;
	@Override
	public String toString() {
		return "Itemlist [itemserialnumber=" + itemserialnumber + ", itemquantity=" + itemquantity + ", itemprice="
				+ itemprice + ", itemname=" + itemname + "]";
	}
}
