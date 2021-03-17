package com.xworkz.library.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SFUtil {
	
	private static SessionFactory factory;
	
	private SFUtil() {
		System.out.println("created SFUtil");
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	static {
		System.out.println("initializing session factory static block");
		try {
		Configuration configuration=new Configuration();
		configuration.configure();
		//configuration.addAnnotatedClass(annotatedClass);
		factory=configuration.buildSessionFactory();
		if(factory!=null) {
			System.out.println("session factory created successfully");
		}else {
			throw new com.xworkz.library.exception.SessionFactoryCreationException("Session Factory can not created");
		}
		
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
		
	}
	}
}
