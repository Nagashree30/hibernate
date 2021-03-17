package com.xworkz.bbc.util;

import com.xworkz.bbc.dao.BBCDAO;
import com.xworkz.bbc.dao.BBCDAOImpl;
import com.xworkz.bbc.entity.BBCEntity;

public class GetIdTester {

	public static void main(String[] args) {

		BBCDAO dao=new BBCDAOImpl();
		BBCEntity entity= dao.getById(3);
		System.out.println(entity);
		System.out.println(entity.getName());
		System.out.println("successfully fetch the BBCEntity record by Id ");
		
	}

}
