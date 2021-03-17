package com.xworkz.rich;

import com.xworkz.rich.dao.RichDAO;
import com.xworkz.rich.dao.RichDAOImpl;
import com.xworkz.rich.entity.RichEntity;

public class KavithaTester {
	public static void main(String[] args) {

		RichEntity entity = new RichEntity();
		entity.setId(1);
		entity.setName("Bill gates");
		entity.setNetWorthInBillions(134);
		entity.setCountry("USA");
		entity.setMarried(true);
		entity.setRank(3);
		entity.setBusiness("software");

		RichEntity entity1 = new RichEntity();
		entity1.setId(2);
		entity1.setName("Elon Musk");
		entity1.setNetWorthInBillions(197);
		entity1.setCountry("American");
		entity1.setMarried(true);
		entity1.setRank(1);
		entity1.setBusiness("industrial designer");

		RichDAO richDAO = new RichDAOImpl();
		//richDAO.create(entity);
		richDAO.create(entity1);
	}

}
