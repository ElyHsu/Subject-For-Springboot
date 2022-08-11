package com.foway.mason.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.foway.mason.dao.CouponDao;
import com.foway.mason.vo.Coupon;

@Repository
public class CouponDaoImpl implements CouponDao {
	@PersistenceContext
	private Session session; 

	public Session getSession() {
		return this.session;
	}

//select方法(利用名稱查流水號,新增coupon紀錄使用)
	public Integer selectcouponserialnumber(String couponname) {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
		// FROM Coupon
		Root<Coupon> root = criteriaQuery.from(Coupon.class);
		// SELECT couponserialnumber
		criteriaQuery = criteriaQuery.select(root.get("couponserialnumber"));
		// couponname= name
		Predicate p1 = criteriaBuilder.equal(root.get("couponname"), couponname);
		// where couponname
		criteriaQuery = criteriaQuery.where(p1);

		TypedQuery<Integer> typedQuery = this.getSession().createQuery(criteriaQuery);
		Integer result = typedQuery.getSingleResult();
		return result;
	}

	// selectALll(維護人員觀看使用)
	@Override
	public List<Coupon> selectall() {
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Coupon> criteriaQuery = criteriaBuilder.createQuery(Coupon.class);
		// FROM Coupon
		Root<Coupon> root = criteriaQuery.from(Coupon.class);

		TypedQuery<Coupon> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<Coupon> result = typedQuery.getResultList();
		return result;
	}

	// selectone(目前無使用)
	String couponhq2 = "from Coupon where couponname = :couponname "; // HQL
	@Override
	public Coupon selectone(Coupon coupon) {
		Coupon resultone = getSession().createQuery(couponhq2, Coupon.class) // HQL
				.setParameter("couponname", coupon.getCouponname())
				.uniqueResult();
		return resultone;
	}
	
	// selectcouponname(與前端輸入進行比對)
	String couponhq3 = "select couponname from Coupon where couponname = :couponname "; // HQL
	@Override
	public String selectcouponname(String couponname) {
		String resultone = getSession().createQuery(couponhq3, String.class) // HQL
				.setParameter("couponname",couponname)
				.uniqueResult();
		return resultone;
	}
	
	// selectcoupon refundpercent(顯示於網頁)
	String couponhq4 = "select refundpercent from Coupon where couponname = :couponname "; // HQL
	@Override
	public Float selectcouporefundpercent(String couponname) {
		Float resultrefundpercent= getSession().createQuery(couponhq4, Float.class) // HQL
				.setParameter("couponname",couponname)
				.uniqueResult();
		return resultrefundpercent;
	}
	
	// select selectbycouponId  (給訂單主檔抓回饋數使用)
	String couponhq5 = "select refundpercent from Coupon where couponserialnumber = :couponserialnumber "; // HQL
	@Override
	public Float selectbyCouponId(Integer couponserialnumber) {
		Float resultrefundpercentbyid= getSession().createQuery(couponhq5, Float.class) // HQL
				.setParameter("couponserialnumber",couponserialnumber)
				.uniqueResult();
		return resultrefundpercentbyid;
	}

//insert方法
	@Override
	public Coupon insert(Coupon coupon) {
		Serializable pk = getSession().save(coupon);
		return coupon;
	}

//update方法
	@Override
	public Coupon update(Coupon coupon) {
		if (coupon != null && coupon.getCouponserialnumber() != null) { // 如果傳入參數或是id不是空值
			Coupon temp = this.getSession().get(Coupon.class, coupon.getCouponserialnumber()); // 把該筆資料撈出
			if (temp != null) {
				return (Coupon) this.getSession().merge(coupon);
			}
		}
		return null;
	}

//delete方法
	@Override
	public boolean remove(Integer couponserialnumber) {
		if (couponserialnumber != null) {
			Coupon temp = this.getSession().get(Coupon.class, couponserialnumber);
			if (temp != null) {
				this.getSession().remove(temp);
				return true;
			}
		}
		return false;
	}

}
