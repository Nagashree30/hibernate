package com.xworkz.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.entity.CartoonEntity;
import com.xworkz.hibernate.util.SFUtil;

public class CartoonDAOImpl  implements CartoonDAO{

	private SessionFactory factory=SFUtil.getFactory();
	@Override
	public void create(List<CartoonEntity> entites) {
		Transaction transaction=null;
		System.out.println("Invoke created");
		try( Session session=factory.openSession()){
			transaction=session.beginTransaction();
			for (CartoonEntity cartoonEntity : entites) {
				session.save(cartoonEntity);
				
			}
			transaction.commit();
		}

		
	}

	@Override
	public CartoonEntity findByName(String name) {
		System.out.println("Invoke created");
		try( Session session=factory.openSession()){
		String hqlQuery="SELECT CART FROM CartoonEntity CART WHERE CART.name='"+name+"' ";
		Query<CartoonEntity> query=session.createQuery(hqlQuery);
		CartoonEntity cartoonEntity =query.uniqueResult();
		
		return cartoonEntity;
	}
	}

	@Override
	public CartoonEntity findByNameAndLang(String name, String lang) {
		System.out.println("Invoke created");
		try( Session session=factory.openSession()){
		String hqlQuery="SELECT CART FROM CartoonEntity CART WHERE CART.name='"+name+"' AND CART.lang='"+lang+"'";
		Query<CartoonEntity> query=session.createQuery(hqlQuery);
		CartoonEntity cartoonEntity =query.uniqueResult();
		
		return cartoonEntity;
	}

}
}
