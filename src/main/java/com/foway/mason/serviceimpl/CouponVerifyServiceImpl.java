package com.foway.mason.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foway.mason.dao.CouponDao;
import com.foway.mason.dao.CouponRecordDao;
import com.foway.mason.service.CouponVerifyService;
import com.foway.mason.vo.CouponRecord;

//用過coupon直接insert使用紀錄
@Service
public class CouponVerifyServiceImpl implements CouponVerifyService {
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private CouponRecordDao couponRecordDao;
	
//  被接管
//	public CouponVerifyServiceImpl() {
//		couponDao = new CouponDaoImpl();
//		couponRecordDao = new CouponRecordDaoImpl();
//	}
	
	@Override
	@Transactional
	public String Couponverify(String couponname) {
		if (couponname != null) {
			if (couponname.equals(couponDao.selectcouponname(couponname))) { // 如果輸入的名字=資料庫名字
				if (couponRecordDao.selectbyrecordpk(couponname, 1636001) == null) { // (應getMemberserialnumber())
					CouponRecord couponRecord = new CouponRecord(); // 如果使用狀態沒有紀錄,新增一筆紀錄
					couponRecord.setCouponserialnumber(couponDao.selectcouponserialnumber(couponname));
					couponRecord.setMemberserialnumber(1636001);
					couponRecord.setCouponrecordstatus(1);
					couponRecordDao.insert(couponRecord); // 新增到資料庫
					return "使用Coupon券成功，本次回饋數為" + String.valueOf(Couponrefundpercent(couponname));
				} else {
					return "此優惠券已被您使用";
				}
			}
			return "查無此優惠券";
		} else {
			return "請輸入優惠碼";
		}
	}

	@Override
	@Transactional
	public Float Couponrefundpercent(String couponname) { // 用couponname呼叫selectcouporefundpercent查饋數
		Float refundpercent = couponDao.selectcouporefundpercent(couponname);
		return refundpercent;
	}

	@Override
	@Transactional
	public String Couponnamestr(String couponname) { // 用couponname呼叫selectcouponname丟到前端
		String couponnamestr = couponDao.selectcouponname(couponname);
		return couponnamestr;
	}

}
