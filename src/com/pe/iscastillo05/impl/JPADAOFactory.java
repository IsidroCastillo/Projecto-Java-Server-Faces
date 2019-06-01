package com.pe.iscastillo05.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactory {

	private static final String PERSISTENCE_UNIT_NAME = "JavaServerFaces";
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManager createEntityManager() {
		if(entityManager == null || !entityManager.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	public static void close() {
		 entityManager.close();
	}
}
