package com.foway.mason.daoimpl;

import java.io.Serializable;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foway.mason.dao.OrderDetailDao;
import com.foway.mason.vo.OrderDetail;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

//新增產品細項
	@Override
	public Serializable insert(OrderDetail vo) {
		return getSession().save(vo);
	}
}
