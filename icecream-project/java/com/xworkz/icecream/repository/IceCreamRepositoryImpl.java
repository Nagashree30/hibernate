package com.xworkz.icecream.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.icecream.entity.IceCreamEntity;

public class IceCreamRepositoryImpl implements IceCreamRepository {

	@Override
	public void create(IceCreamEntity entity) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");

		EntityManager session = factory.createEntityManager();
		session.getTransaction().begin();
		session.persist(entity);
		System.out.println(entity);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	@Override
	public void deleteByName(String name) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");

		EntityManager session = factory.createEntityManager();
		session.getTransaction().begin();
		Query query = session.createNamedQuery("deleteByName");
		query.setParameter("name", name);
		Integer num = query.executeUpdate();
		System.out.println(num);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}

	@Override
	public void updatePriceByName(String name, double price) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");

		EntityManager session = factory.createEntityManager();
		session.getTransaction().begin();
		Query query = session.createNamedQuery("updatePriceByName");
		query.setParameter("name", name);
		query.setParameter("price", price);
		int q = query.executeUpdate();
		System.out.println(q);
		session.getTransaction().commit();
		session.close();
		factory.close();

	}

	@Override
	public List<IceCreamEntity> getAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");

		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("getAll");
		List<IceCreamEntity> list = query.getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	public IceCreamEntity findByNameAndPrice(String name, double price) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");

		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("findByNameAndPrice");
		query.setParameter("name", name);
		query.setParameter("price", price);
		return (IceCreamEntity) query.getSingleResult();
	}

	@Override
	public IceCreamEntity getByMaxPrice() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");

		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("getByMaxPrice");
		List list = query.getResultList();
		System.out.println(list);
		return (IceCreamEntity) list;

	}

	@Override
	public IceCreamEntity getByMinPrice() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");
		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("getByMinPrice");
		List list = query.getResultList();
		System.out.println(list);
		return (IceCreamEntity) list;
	}

	@Override
	public double getPriceByName(String name) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");
		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("getPriceByName");
		query.setParameter("name", name);
		return (double) query.getSingleResult();

	}

	@Override
	public List<Object[]> getNameAndFlavourByPrice(double price) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");
		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("getNameAndFlavourByPrice");
		query.setParameter("price", price);
		List<Object[]> entity = query.getResultList();

		return entity;
	}

	@Override
	public double getBySumPrice() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz.jpa");
		EntityManager session = factory.createEntityManager();
		Query query = session.createNamedQuery("getBySumPrice");
		return (double) query.getSingleResult();

	}

}
