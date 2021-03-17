package com.xworkz.bbc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.bbc.entity.BBCEntity;

public class BBCDAOImpl implements BBCDAO {

	@Override
	public void create(BBCEntity entity) {
		System.out.println("invoke create");
		System.out.println("entity :" + entity);
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(BBCEntity.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
		factory.close();
	}

	@Override
	public BBCEntity getById(int id) {
		System.out.println("invoke create");
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(BBCEntity.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		BBCEntity bbcEntity = session.get(BBCEntity.class, id);
		transaction.commit();
		session.close();
		factory.close();

		return bbcEntity;
	}

	@Override
	public BBCEntity updateNoOfTaskAndDaysInById(int id, int noOfTask, int daysIn) {

		SessionFactory factory=new Configuration().configure().addAnnotatedClass(BBCEntity.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		BBCEntity entityFromDB=session.get(BBCEntity.class, id);
		if(entityFromDB!=null) {
			System.out.println("id can update, id is found"+id);
			entityFromDB.setNoOfTask(noOfTask);
			entityFromDB.setDaysIn(daysIn);
			transaction.commit();
		}else {
			System.out.println("id is not valid, entity is not able to update");
		}
		
		factory.close();
		
		return entityFromDB;
	}

	@Override
	public void deleteById(int id) {

		SessionFactory factory=new Configuration().configure().addAnnotatedClass(BBCEntity.class).buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		BBCEntity entityFromDB=session.get(BBCEntity.class, id);
		if(entityFromDB!=null) {
			System.out.println("id can delete, id is found"+id);
			session.delete(entityFromDB);
			transaction.commit();
			session.close();
			factory.close();
		}else {
			System.out.println("id is not found it can't be deleted");
		}
		
		
	}

}
