package com.xworkz.library.util;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.library.dao.LibraryDAO;
import com.xworkz.library.dao.LibraryDAOImpl;
import com.xworkz.library.entity.LibraryEntity;

public class LibraryTester {
	public static void main(String[] args) {
		
		LibraryEntity entity=new LibraryEntity("Ramya", "public", 200, "Novels");
		LibraryEntity entity1=new LibraryEntity("Lalitha", "private", 320, "gernals");
		LibraryEntity entity2=new LibraryEntity("Nanditha", "college", 1220, "Comedy");
		LibraryEntity entity3=new LibraryEntity("Nayana", "public", 520, "Story");
		
		List<LibraryEntity> entities=new ArrayList<LibraryEntity>();
		entities.add(entity);
		entities.add(entity1);
		entities.add(entity2);
		
		entities.add(entity3);
		
		LibraryDAO dao=new LibraryDAOImpl();
//		dao.create(entity);
//		dao.updateLibrarianNameAndNoOfBooksById(1, "amulya", 9000);
//		dao.getById(5);
//		dao.create(entities);
//		dao.deleteById(2);
		dao.getAll();
		
	}
	
	
		
		

}
