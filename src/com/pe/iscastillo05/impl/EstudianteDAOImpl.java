package com.pe.iscastillo05.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.pe.iscastillo05.beans.Estudiante;
import com.pe.iscastillo05.dao.EstudianteDAO;

public class EstudianteDAOImpl extends BaseJPADAO implements EstudianteDAO {

	@Override
	public Estudiante getById(int id) {
	
		Estudiante estudiante = getEntityManager().find(Estudiante.class, id);
		getEntityManager().close();
		return estudiante;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> getAll() {
		String sql = "SELECT e FROM Estudiante e";
		Query query = getEntityManager().createQuery(sql, Estudiante.class);
		List<Estudiante> list = query.getResultList();
		if (list.size() != 0) {
			closeEntityManager();
			return list;
		} else {
			closeEntityManager();
			return null;
		}
	}

	@SuppressWarnings("null")
	@Override
	public Estudiante create(Estudiante obj) {
		if (obj == null && obj.getId() != 0) {
			return null;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		Estudiante updateObj = getEntityManager().find(Estudiante.class, obj.getId());
		if (!t.isActive()) {
			t.begin();
		}
		updateObj.setNombres(obj.getNombres());
		t.commit();
		closeEntityManager();
		return obj;
	}

	@Override
	public Estudiante update(Estudiante obj) {
		int maxId = getMaxId();
		obj.setId(maxId);

		EntityTransaction t = getEntityManager().getTransaction();
		if (!t.isActive()) {
			t.begin();
		}
		getEntityManager().persist(obj);
		t.commit();
		closeEntityManager();
		return obj;
	}

	@Override
	public boolean delete(int id) {
		if (id == 0) {
			return false;
		}

		Estudiante obj = getById(id);
		if (obj == null) {
			return false;
		}

		EntityTransaction t = getEntityManager().getTransaction();
		if (!t.isActive()) {
			t.begin();
		}
		getEntityManager().remove(getEntityManager().merge(obj));
		t.commit();
		closeEntityManager();
		return true;
	}

	private int getMaxId() {
		String sql = "SELECT max(e.id)+1 FROM Estudiante e";
		Query query = getEntityManager().createQuery(sql, int.class);
		int maxId = (query.getSingleResult() == null) ? 1 : (int) query.getSingleResult();
		closeEntityManager();
		return maxId;
	}
}
