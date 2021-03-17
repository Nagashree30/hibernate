package com.xworkz.library.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.library.entity.LibraryEntity;
import com.xworkz.library.util.SFUtil;

public class LibraryDAOImpl implements LibraryDAO {
	public LibraryDAOImpl() {
	}

	public SessionFactory factory = SFUtil.getFactory();

	@Override
	public void create(LibraryEntity entity) {
		System.out.println("Invoke create");
		System.out.println("entity" + entity);
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		}
	}

	@Override
	public void deleteById(int id) {

		System.out.println("Invoke deleteById");
		System.out.println("Id " + id);
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			LibraryEntity entityFromDB = session.get(LibraryEntity.class, id);
			session.delete(entityFromDB);
			transaction.commit();
			System.out.println("deleted id is" + entityFromDB);
			System.out.println("id deleted successfully...");
		}
	}

	@Override
	public void updateLibrarianNameAndNoOfBooksById(int id, String librarian, int noOfBooks) {

		System.out.println("Invoke updateLibrarianNameAndNoOfBooksById method ");
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			LibraryEntity entityFromDB = session.get(LibraryEntity.class, id);
			entityFromDB.setLibrarian(librarian);
			entityFromDB.setNoOfBooks(noOfBooks);
			session.update(entityFromDB);
			transaction.commit();
		}
	}

	@Override
	public LibraryEntity getById(int id) {
		System.out.println("Invoke getById");
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			LibraryEntity libraryEntity = session.get(LibraryEntity.class, id);
			transaction.commit();
			System.out.println(libraryEntity);

			return libraryEntity;
		}

	}

	@Override
	public void create(List<LibraryEntity> entities) {
		System.out.println("Invoke create method");
		System.out.println("entities" + entities);

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			for (LibraryEntity libraryEntity : entities) {
				session.save(libraryEntity);
			}
			transaction.commit();
		}
	}
	
//	public void listEmployees( ){
//	      Session session = factory.openSession();
//	      Transaction tx = null;
//	      
//	      try {
//	         tx = session.beginTransaction();
//	         List employees = session.createQuery("FROM Employee").list(); 
//	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
//	            Employee employee = (Employee) iterator.next(); 
//	            System.out.print("First Name: " + employee.getFirstName()); 
//	            System.out.print("  Last Name: " + employee.getLastName()); 
//	            System.out.println("  Salary: " + employee.getSalary()); 
//	         }
//	         tx.commit();
//	      } catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      } finally {
//	         session.close(); 
//	      }
//	   }

	@Override
	public void getAll() {

		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
		//	LibraryEntity libraryEntity = session.get(LibraryEntity.class, id);
			List<LibraryEntity> library = session.createQuery("Select  from  xworkz.library").list(); 
			for (LibraryEntity libraryEntity : library) {
				System.out.println(libraryEntity.getId());
				System.out.println(libraryEntity.getLibrarian());
				System.out.println(libraryEntity.getNoOfBooks());
				System.out.println(libraryEntity.getTypeOfLibrary());
				System.out.println(libraryEntity.getDivisionName());
			}
			
			transaction.commit();
			System.out.println(session.getClass());
			transaction.commit();

		}
	    	 
	}
}
