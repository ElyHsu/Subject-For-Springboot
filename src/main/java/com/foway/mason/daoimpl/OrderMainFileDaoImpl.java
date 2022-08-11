package com.foway.mason.daoimpl;

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
		System.out.println("merge-method");
		Session session = getSession();
		OrderMainFile vo = (OrderMainFile) session.merge(orderMainFileHibernate);
		return vo;
	}

}
