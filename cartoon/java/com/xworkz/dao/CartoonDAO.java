package com.xworkz.dao;

import java.util.List;

import com.xworkz.entity.CartoonEntity;

public interface CartoonDAO {

	public void create(List<CartoonEntity> entites);

	public CartoonEntity findByName(String name);

	public CartoonEntity findByNameAndLang(String name, String lang);

}
