package com.xworkz.tester;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.dao.CartoonDAO;
import com.xworkz.dao.CartoonDAOImpl;
import com.xworkz.entity.CartoonEntity;
import com.xworkz.entity.CartoonEntity.ChannelName;

public class Tester {

	public static void main(String[] args) {

		CartoonEntity entity=new CartoonEntity("oggy","oggy",ChannelName.CN,"english");
		CartoonDAO dao=new CartoonDAOImpl();
		List<CartoonEntity> entites=new ArrayList<CartoonEntity>();
		entites.add(entity);
		 dao.create(entites);
	}

}
