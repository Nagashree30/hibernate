package com.xworkz.rich.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.rich.entity.RichEntity;

public class RichDAOImpl implements RichDAO {

	@Override
	public void create(RichEntity entity) {
		System.out.println("invoke create");
		System.out.println("entity :" + entity);
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(RichEntity.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
		factory.close();

	}

}
