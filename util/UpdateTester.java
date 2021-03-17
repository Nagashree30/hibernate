package com.xworkz.bbc.util;

import com.xworkz.bbc.dao.BBCDAO;
import com.xworkz.bbc.dao.BBCDAOImpl;
import com.xworkz.bbc.entity.BBCEntity;

public class UpdateTester {
	public static void main(String[] args) {
		
		BBCDAO dao=new BBCDAOImpl();
		BBCEntity entity=dao.updateNoOfTaskAndDaysInById(1, 2, 2);
		System.out.println(entity);
	}

}
