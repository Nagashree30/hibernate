package com.xworkz.bbc.util;

import com.xworkz.bbc.dao.BBCDAO;
import com.xworkz.bbc.dao.BBCDAOImpl;

public class DeleteTester {

	public static void main(String[] args) {
		BBCDAO dao=new BBCDAOImpl();
		 dao.deleteById(4);
	}

}
