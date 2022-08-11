package com.foway.mason.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foway.mason.dao.MemberDao;
import com.foway.mason.service.GoldRemainingCheckService;

@Service
public class GoldRemainingCheckServiceImpl implements GoldRemainingCheckService {
	@Autowired
	private MemberDao memberHibernateDao;
	
//  被接管
//	public GoldRemainingCheckServiceImpl() {
//		memberHibernateDao = new MemberDaoImpl();
//	}

	@Override
	@Transactional
	public String CouponverifyGoldRemaining(Integer goldremaining) {
		if (goldremaining != null) {
			if (goldremaining <= memberHibernateDao.selectgoldremaininghibernate(goldremaining)) {
				return "購物金使用成功";
			} else {
				return "購物金餘額不足";
			}
		} else {
			return "請輸入欲使用購物金金額";
		}
	}
}
