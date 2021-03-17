package com.xworkz.product.tester;

import java.util.List;

import com.xworkz.product.dao.ProductDAO;
import com.xworkz.product.dao.ProductDAOImpl;
import com.xworkz.product.entity.ProductEntity;
import com.xworkz.product.entity.ProductEntity.ProductType;

public class ProductTester {
	public static void main(String[] args) {

		ProductDAO dao = new ProductDAOImpl();
		ProductEntity entity=new  ProductEntity("Grinder", ProductType.HOME_APPLIANCES, 5, 1, true, "usha", "Panasonic");
		dao.persist(entity);
		dao.findMaxId();
		dao.findMinId();
		dao.findMaxPrice();
		dao.findNameAndTypeById(2);
		dao.findSize();
		dao.findByNameAndManufacturer("Grinder", "usha");
		dao.findByTypeAndBrandAndName("Grinder", "Panasonic", ProductType.HOME_APPLIANCES);
		dao.findByTypeAndBrandAndQuality("Fan", "Havells", true);
		dao.findPriceAndQuantityByTypeAndBrandAndName("Grinder", "Panasonic", ProductType.HOME_APPLIANCES);
		dao.findDistinct();
		dao.findPriceByTypeAndBrandAndName("Grinder", "Panasonic", ProductType.HOME_APPLIANCES);
		dao.findSumOfPrice();
		
		
		List<Integer>  distinct=dao.findDistinct();

	}

}
