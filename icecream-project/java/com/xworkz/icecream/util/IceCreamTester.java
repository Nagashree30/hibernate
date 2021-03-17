package com.xworkz.icecream.util;

import com.xworkz.icecream.entity.IceCreamEntity;
import com.xworkz.icecream.entity.IceCreamEntity.Color;
import com.xworkz.icecream.entity.IceCreamEntity.Flavour;
import com.xworkz.icecream.repository.IceCreamRepository;
import com.xworkz.icecream.repository.IceCreamRepositoryImpl;

public class IceCreamTester {
	public static void main(String[] args) {
		
		IceCreamEntity entity=new IceCreamEntity(4,"Amul ", "Edy's ", 10, Flavour.VANILLA, Color.WHITE);
		IceCreamRepository repo=new IceCreamRepositoryImpl();
		//repo.create(entity);
		
		repo.deleteByName("Amul");
		
		//repo.updatePriceByName("Arun", 2000);
		
		//repo.getAll();
		
		//repo.getByNameAndPrice("Arun", 300);
		
		//repo.getByMinPrice();
		
		//repo.getPriceByName("Grape-Nut ice cream");
	}

}
