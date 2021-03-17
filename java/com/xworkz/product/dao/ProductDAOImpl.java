package com.xworkz.product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.hibernate.util.SFUtil;
import com.xworkz.product.entity.ProductEntity;
import com.xworkz.product.entity.ProductEntity.ProductType;

public class ProductDAOImpl implements ProductDAO {

	private SessionFactory factory = SFUtil.getFactory();
	Transaction transaction = null;

	@Override
	public void persist(ProductEntity entity) {
		System.out.println("Invoke Persist");
		System.out.println("entity" + entity);
		try (Session session = factory.openSession()) {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		}
	}

	@Override
	public ProductEntity findByNameAndManufacturer(String name, String manufacturer) {
		try (Session session = factory.openSession()) {
			String hqlQuery = "SELECT product from ProductEntity product where product.name=:nm and "
					+ "product.manufacturer=:manufacture";
			Query<ProductEntity> query = session.createQuery(hqlQuery);
			query.setParameter("nm", name);
			query.setParameter("manufacture", manufacturer);
			ProductEntity hql = query.uniqueResult();
			return hql;
		}
	}

	@Override
	public ProductEntity findByTypeAndBrandAndName(String name, String brand, ProductType type) {

		try (Session session = factory.openSession()) {
			String hqlQuery = "SELECT product from ProductEntity product where product.name=:nam and product.brand=:brand and product.type=:type";
			Query<ProductEntity> query = session.createQuery(hqlQuery);
			query.setParameter("nam", name);
			query.setParameter("brand", brand);
			query.setParameter("type", type);
			ProductEntity hql = query.uniqueResult();
			System.out.println(hql);
			return hql;

		}

	}

	@Override
	public Double findPriceByTypeAndBrandAndName(String name, String brand, ProductType type) {

		try (Session session = factory.openSession()) {
			String hqlquery = "SELECT product.price FROM ProductEntity product where product.name=:nam and "
					+ "product.brand=:brand and product.type=:type ";
			Query<Double> query = session.createQuery(hqlquery);
			query.setParameter("nam", name);
			query.setParameter("brand", brand);
			query.setParameter("type", type);
			Double hql = query.uniqueResult();
			return hql;
		}
	}

	@Override
	public Object[] findPriceAndQuantityByTypeAndBrandAndName(String name, String brand, ProductType type) {

		try (Session session = factory.openSession()) {
			String hqlquery = "SELECT product.price,product.quantity FROM ProductEntity product where "
					+ "product.name=:nam and product.brand=:brand and product.type=:type ";
			Query<Object[]> query = session.createQuery(hqlquery);
			query.setParameter("nam", name);
			query.setParameter("brand", brand);
			query.setParameter("type", type);
			Object[] hql = query.uniqueResult();
			return hql;
		}
	}

	@Override
	public ProductEntity findByTypeAndBrandAndQuality(String name, String brand, boolean quality) {

		try (Session session = factory.openSession()) {
			String hqlQuery = "SELECT product from ProductEntity product where product.name=:nam "
					+ "and product.brand=:brand and product.quality=:quality";
			Query<ProductEntity> query = session.createQuery(hqlQuery);
			query.setParameter("nam", name);
			query.setParameter("brand", brand);
			query.setParameter("quality", quality);
			ProductEntity hql = query.uniqueResult();
			return hql;
		}
	}

	@Override
	public Object[] findNameAndTypeById(int id) {
		try (Session session = factory.openSession()) {
			String hqlquery = "SELECT product.name, product.type FROM ProductEntity product where product.id=:id";
			Query<Object[]> query = session.createQuery(hqlquery);
			query.setParameter("id", id);
			Object[] hql = query.uniqueResult();
			return hql;
		}
	}

	@Override
	public int findMaxId() {
		try (Session session = factory.openSession()) {
			String hqlQuery = "Select max(id) from ProductEntity ";
			Query<Integer> query = session.createQuery(hqlQuery);
			Integer hql = query.uniqueResult();
			System.out.println(hql);
			return hql;
		}
	}

	@Override
	public long findSize() {
		try (Session session = factory.openSession()) {
			String hqlQuery = "Select count(*) from ProductEntity ";
			Query<Long> query = session.createQuery(hqlQuery);
			Long hql = query.uniqueResult();
			System.out.println(hql);
			return hql;
		}
	}

	@Override
	public double findMaxPrice() {
		try (Session session = factory.openSession()) {
			String hqlQuery = "Select max(price) from ProductEntity ";
			Query<Double> query = session.createQuery(hqlQuery);
			Double hql = query.uniqueResult();
			System.out.println(hql);
			return hql;
		}
	}

	@Override
	public double findSumOfPrice() {
		try (Session session = factory.openSession()) {
			String hqlQuery = "Select sum(price) from ProductEntity ";
			Query<Double> query = session.createQuery(hqlQuery);
			Double hql = query.uniqueResult();
			System.out.println(hql);
			return hql;
		}

	}

	@Override
	public int findMinId() {
		try (Session session = factory.openSession()) {
			String hqlQuery = "Select min(id) from ProductEntity ";
			Query<Integer> query = session.createQuery(hqlQuery);
			Integer hql = query.uniqueResult();
			System.out.println(hql);
			return hql;
		}
	}

	@Override
	public List<Integer> findDistinct() {
		try (Session session = factory.openSession()) {
			String hqlQuery = "Select distinct product  from ProductEntity product";
			Query<Integer> query = session.createQuery(hqlQuery);
			List<Integer> hql = query.getResultList();
			System.out.println(hql);
			return hql;

		}
	}

}
