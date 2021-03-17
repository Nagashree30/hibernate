package com.xworkz.coupon.dao;

import java.util.List;

import com.xworkz.coupon.entity.CouponEntity;

public interface CouponDAO {
	
	public void create(CouponEntity entity);
	
	public void deleteById(int id);

	public void updateCodeAndValidityById(int id, String code, int validityInMonths);

	public CouponEntity getById(int id);
	
	public void create(List<CouponEntity> entities);


}
