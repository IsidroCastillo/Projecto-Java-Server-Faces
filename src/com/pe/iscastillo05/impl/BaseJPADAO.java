package com.pe.iscastillo05.impl;

import javax.persistence.EntityManager;

public class BaseJPADAO extends JPADAOFactory {

	public static EntityManager getEntityManager() {
		return JPADAOFactory.createEntityManager();
	}
	public static void closeEntityManager() {
		JPADAOFactory.close();
	}
}
