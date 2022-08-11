package com.foway.mason.daoimpl;

import java.io.Serializable;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foway.mason.dao.CouponDao;
import com.foway.mason.dao.CouponRecordDao;
import com.foway.mason.vo.CouponRecord;

@Repository
public class CouponRecordDaoImpl implements CouponRecordDao {
	@PersistenceContext
	private Session session;  

	public Session getSession() {
		return this.session;
	}

	public CouponRecordDaoImpl() {
	}
	
//select方法(比對紀錄、查詢該會員使用優惠券狀態)
	String couponrecordhql = "select couponrecordstatus from CouponRecord where couponserialnumber = :couponserialnumber and memberserialnumber = :memberserialnumber";
	@Autowired
	CouponDao couponDao;   //CouponDao couponDao = new CouponDaoImpl();
	
	@Override
	public Integer selectbyrecordpk(String couponname, Integer memberserialnumber) {
		Integer resultscouponrecord = getSession().createQuery(couponrecordhql, Integer.class)
				.setParameter("couponserialnumber", couponDao.selectcouponserialnumber(couponname))
				.setParameter("memberserialnumber", memberserialnumber).uniqueResult();	
		return resultscouponrecord;
	}


////insert方法(消費者使用時新增紀錄)
	@Override
	public CouponRecord insert(CouponRecord couponRecord) {
		if (couponRecord != null && couponRecord.getCouponserialnumber() != null) {
				Serializable pk = this.getSession().save(couponRecord);
				return couponRecord;
		}
		return null;
	}
}
