package com.foway.mason.daoimpl;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foway.mason.dao.MemberDao;

@Repository
public class MemberDaoImpl implements MemberDao {
	@PersistenceContext
	private Session session;

	public Session getSession() {
		return this.session;
	}

	public MemberDaoImpl() {
	}

	// select購物金存量方法(利用會員ID)
	String Memberhq1 = "select goldremaining from Member where memberserialnumber = :memberserialnumber "; // HQL

	@Override
	public Integer selectgoldremaininghibernate(Integer memberserialnumber) {
		Integer resultone = getSession().createQuery(Memberhq1, Integer.class) // HQL
				.setParameter("memberserialnumber", 1636001).uniqueResult();
		return resultone;
	}

}
