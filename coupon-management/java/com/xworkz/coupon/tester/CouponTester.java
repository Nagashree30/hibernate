package com.xworkz.coupon.tester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.coupon.dao.CouponDAO;
import com.xworkz.coupon.dao.CouponDAOImpl;
import com.xworkz.coupon.entity.CouponEntity;

public class CouponTester {
	public static void main(String[] args) {
			
		CouponEntity entity=new CouponEntity();
		entity.setName("Lenscart");
		entity.setCode("124JSGY0");
		entity.setType("Specs");
		entity.setValidityInMonths(8);
		CouponEntity entity1=new CouponEntity();
		entity1.setName("Footware");
		entity1.setCode("ASDJSGY0");
		entity1.setType("slipper");
		entity1.setValidityInMonths(1);
		
		List<CouponEntity> entities=new ArrayList<CouponEntity>();
		entities.add(entity);
		entities.add(entity1);
		
		CouponDAO dao=new CouponDAOImpl();
			
			dao.create(entity);
			dao.create(entity1);
			dao.getById(1);
			dao.updateCodeAndValidityById(2, "RWDD098", 9);
			dao.deleteById(3);
			dao.create(entities);
			}
}



















//		 Integer p = 5;
//		 Integer q = 20;
//		 Integer r =5;
//		 Short s = 5;
//		 System.out.println(p.equals(q));
//		 System.out.println(p.equals(r));
//		 System.out.println(p.equals(s));
//		 }
//		}
