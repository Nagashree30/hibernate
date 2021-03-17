package com.xworkz.bbc.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.bbc.entity.BBCEntity;

public class NaguTester {
//This not a way to update the db bcz if we update one property it will allocate default values to the  remaining properties;
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure().addAnnotatedClass(BBCEntity.class);
		SessionFactory factory = null;
		try {
			factory = cfg.buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			BBCEntity entity = new BBCEntity();
			entity.setId(1);
			entity.setName("Nidhi s");
			entity.setContestantType("Actor");
			entity.setDaysIn(2);
			entity.setGender("Female");
			entity.setNoOfTask(2);
			entity.setSeasonNo(8);
			session.update(entity);
			transaction.commit();
		} finally {
			factory.close();
		}

	}

}
