package com.foway.mason.serviceimpl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foway.mason.dao.CouponDao;
import com.foway.mason.dao.OrderDetailDao;
import com.foway.mason.dao.OrderMainFileDao;
import com.foway.mason.service.OrderMainFileService;
import com.foway.mason.vo.Cart;
import com.foway.mason.vo.Itemlist;
import com.foway.mason.vo.OrderDetail;
import com.foway.mason.vo.OrderMainFile;

@Service
public class OrderMainFileServiceImpl implements OrderMainFileService {
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private OrderMainFileDao orderMainFileHibernateDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	
//  被接管
//	public OrderMainFileServiceImpl() {
//		couponDao = new CouponDaoImpl();
//		orderMainFileHibernateDao = new OrderMainFileDaoImpl();
//		orderDetailDao = new OrderDetailDaoImpl();
//	}

	@Override
	@Transactional
	public String orderMaininsert(String couponname, Cart cart, List<Itemlist> itemlist, Integer carttotal) {
		Calendar calendar = Calendar.getInstance();
		Integer orderserialnumber = null;
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//		Date curtime= strToDateLong(dateFormat.format(calendar.getTime()));
		if (couponname == null || Objects.equals(couponname, "")) {
			OrderMainFile orderMainFileHibernate = new OrderMainFile();
			orderMainFileHibernate.setMemberserialnumber(1636001);
			orderMainFileHibernate.setSellerserialnumber(1000);
			orderMainFileHibernate.setOrderstatusnumber("1");
			orderMainFileHibernate.setSellerevaluationstar(2);
			orderMainFileHibernate.setMemberevaluationstar(4);
			orderMainFileHibernate.setSellerevaluationdescription("");
			orderMainFileHibernate.setMemberevaluationdescription("");
//			orderMainFileHibernate.setMemberevaluationphoto();
			orderMainFileHibernate.setOrderamount(cart.carttotal);
			orderMainFileHibernate.setOrderdate(calendar.getTime());
			Serializable pk1 = orderMainFileHibernateDao.insert(orderMainFileHibernate);
			System.out.println("id1=" + ((OrderMainFile) pk1).getOrderserialnumber());
			orderserialnumber = ((OrderMainFile) pk1).getOrderserialnumber();
			if (orderserialnumber != null) {
				for (Itemlist itemlist1 : cart.itemlist) {
					OrderDetail oderitem2 = new OrderDetail(); // orderdetail1
					oderitem2.setOrderserialnumber(orderserialnumber);
					oderitem2.setItemserialnumber(itemlist1.itemserialnumber);
					oderitem2.setOrderdetailprice(itemlist1.itemprice);
					oderitem2.setOrderdetailquantity(itemlist1.itemquantity);
					oderitem2.setRefundreason("");
					oderitem2.setOrderdetailstatus(2);
					orderDetailDao.insert(oderitem2);
				}
				return "訂單主檔+細項新增成功";
			}
			return "訂單主檔新增成功";
		} else {
			OrderMainFile orderMainFileHibernate = new OrderMainFile();
			orderMainFileHibernate.setMemberserialnumber(1636001);
			orderMainFileHibernate.setSellerserialnumber(1000);
			orderMainFileHibernate.setOrderstatusnumber("1");
			orderMainFileHibernate.setCouponserialnumber(couponDao.selectcouponserialnumber(couponname));
			// orderMainFileHibernate.setCouponserialnumber(5);
			orderMainFileHibernate.setSellerevaluationstar(2);
			orderMainFileHibernate.setMemberevaluationstar(4);
			orderMainFileHibernate.setSellerevaluationdescription("");
			orderMainFileHibernate.setMemberevaluationdescription("");
			// orderMainFileHibernate.setMemberevaluationphoto();
			orderMainFileHibernate.setOrderamount(cart.carttotal);
			orderMainFileHibernate.setOrderdate(calendar.getTime());
			Serializable pk2 = orderMainFileHibernateDao.insert(orderMainFileHibernate);
			System.out.println("id2=" + ((OrderMainFile) pk2).getOrderserialnumber());
			orderserialnumber = ((OrderMainFile) pk2).getOrderserialnumber();
			/// ====================
			if (orderserialnumber != null) {
				for (Itemlist itemlist1 : cart.itemlist) {
					OrderDetail oderitem = new OrderDetail(); // orderdetail1
					oderitem.setOrderserialnumber(orderserialnumber);
					oderitem.setItemserialnumber(itemlist1.itemserialnumber);
					oderitem.setOrderdetailprice(itemlist1.itemprice);
					oderitem.setOrderdetailquantity(itemlist1.itemquantity);
					oderitem.setRefundreason("");
					oderitem.setOrderdetailstatus(2);
					orderDetailDao.insert(oderitem);
				}
				return "訂單主檔+細項新增成功";
			}
			return "訂單主檔新增成功";
		}

	}

//	 public static Date strToDateLong(String strDate) {
//		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		    ParsePosition pos = new ParsePosition(0);
//		    Date strtodate = formatter.parse(strDate, pos);
//		    return strtodate;
//		 }

}
