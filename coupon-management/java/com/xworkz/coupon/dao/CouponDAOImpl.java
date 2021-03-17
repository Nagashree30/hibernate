package com.xworkz.coupon.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.coupon.entity.CouponEntity;
import com.xworkz.hibernate.util.SFUtil;

public class CouponDAOImpl implements CouponDAO {

	private SessionFactory factory= SFUtil.getFactory();
	@Override
	public void create(CouponEntity entity) {
		System.out.println("Invoke create");
		System.out.println("entity" + entity);
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		}
		

		
	}
	@Override
	public void deleteById(int id) {
		System.out.println("Invoke deleteById");
		System.out.println("Id " + id);
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			CouponEntity entityFromDB = session.get(CouponEntity.class, id);
			session.delete(entityFromDB);
			transaction.commit();
			System.out.println("deleted id is" + entityFromDB);
			System.out.println("id deleted successfully...");
		}
		
	}		
	
	@Override
	public void updateCodeAndValidityById(int id, String code, int validityInMonths) {
		System.out.println("Invoke updateHeightAndDepthById");

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			CouponEntity entityFromDB = session.get(CouponEntity.class, id);
			entityFromDB.setCode(code);
			entityFromDB.setValidityInMonths(validityInMonths);
			session.update(entityFromDB);
			transaction.commit();

		}		
	}
	@Override
	public CouponEntity getById(int id) {
		System.out.println("Invoke getById");
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			CouponEntity couponEntity = session.get(CouponEntity.class, id);
			transaction.commit();
			System.out.println(couponEntity);
	
		return couponEntity;
	}
	} 
	@Override
	public void create(List<CouponEntity> entities) {

		System.out.println("Invoke create method");
		System.out.println("entities" + entities);

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			for (CouponEntity couponEntity : entities) {
				session.save(couponEntity);
			}
			transaction.commit();
		}
	}
	}


