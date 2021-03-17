package com.xworkz.library.dao;

import java.util.List;

import com.xworkz.library.entity.LibraryEntity;

public interface LibraryDAO {

	public void create(LibraryEntity entity);

	public void deleteById(int id);

	public void updateLibrarianNameAndNoOfBooksById(int id, String librarian, int noOfBooks);

	public LibraryEntity getById(int id);
	
	public void create(List<LibraryEntity> entities);
	
	public void getAll();

}
