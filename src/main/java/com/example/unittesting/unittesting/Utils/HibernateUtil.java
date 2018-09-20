package com.example.unittesting.unittesting.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;



public class HibernateUtil {

	@PersistenceContext
	private static EntityManager entityManager;

	private static EntityManagerFactory entityManagerFactory;

	public static void initManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

	}
	public static void shutdown() {
		entityManager.close();
		entityManagerFactory.close();
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}


	
}
