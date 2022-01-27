package com.ty.one_to_many_crud_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.one_to_many_crud_uni.dto.AmazonOrder;
import com.ty.one_to_many_crud_uni.dto.Items;

public class OrderDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveOrder(AmazonOrder amazonOrder) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityTransaction.commit();
	}

	public AmazonOrder getOrder(int id) {
		entityManager = getEntityManager();
		return entityManager.find(AmazonOrder.class, id);
	}

	public void deletOrder(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entityManager.find(AmazonOrder.class, id));
		entityTransaction.commit();
	}

	public void addItemsToOrder(int id, List<Items> items) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);
		List<Items> itemsList = amazonOrder.getItems();
		itemsList.addAll(items);

		entityManager.merge(amazonOrder);
		entityTransaction.commit();
	}
}
