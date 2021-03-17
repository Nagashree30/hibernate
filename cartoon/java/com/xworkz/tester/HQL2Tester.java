package com.xworkz.tester;

import com.xworkz.dao.CartoonDAO;
import com.xworkz.dao.CartoonDAOImpl;
import com.xworkz.entity.CartoonEntity;

public class HQL2Tester {

	public static void main(String[] args) {

		CartoonDAO dao= new CartoonDAOImpl();
		CartoonEntity entity=dao.findByNameAndLang("oggy","english");
		System.out.println(entity);
	}

}
