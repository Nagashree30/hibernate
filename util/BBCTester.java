package com.xworkz.bbc.util;

import com.xworkz.bbc.dao.BBCDAO;
import com.xworkz.bbc.dao.BBCDAOImpl;
import com.xworkz.bbc.entity.BBCEntity;

public class BBCTester {

	public static void main(String[] args) {

		BBCEntity bbc = new BBCEntity();
		// bbc.setId(1);
		bbc.setName("dhanushree");
		bbc.setSeasonNo(8);
		bbc.setGender("female");
		bbc.setContestantType("Dancer");
		bbc.setDaysIn(1);
		bbc.setNoOfTask(0);

		BBCEntity bbc1 = new BBCEntity();
		// bbc1.setId(1);
		bbc1.setName("Shamath");
		bbc1.setSeasonNo(8);
		bbc1.setGender("Male");
		bbc1.setContestantType("Singer");
		bbc1.setDaysIn(1);
		bbc1.setNoOfTask(0);

		BBCDAO dao = new BBCDAOImpl();
		dao.create(bbc);
		dao.create(bbc1);

		System.out.println("save the bbc record successfully....");

	}

}
