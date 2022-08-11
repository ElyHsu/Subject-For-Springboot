package com.foway.mason.daoimpl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foway.mason.dao.OrderMainFileDao;
import com.foway.mason.vo.OrderMainFile;

@Repository
public class OrderMainFileDaoImpl implements OrderMainFileDao {
	@PersistenceContext
	private Session session; // 從controller移到這

	public Session getSession() {
		return this.session;
	}

	// insert
	@Override
	public OrderMainFile insert(OrderMainFile orderMainFileHibernate) {
//		System.out.println("merge-method");
		Session session = getSession();
		OrderMainFile vo = (OrderMainFile) session.merge(orderMainFileHibernate);
		return vo;
	}

	// 抓最後一筆編號放到信裡
	String hql1 = " select orderserialnumber from OrderMainFile order by orderserialnumber desc ";
	@Override
	public Integer selectorderserialnumber() {
		List<Integer> orderserialnumber = getSession().createQuery(hql1, Integer.class) 
				.setMaxResults(1).list();  // 即可取得訂單號碼，但是信中的訂單號碼有中括號
		return orderserialnumber.get(0);   // 除去信中的訂單號碼中括號
	}

}
