package com.pe.iscastillo05.dao;

import java.util.List;

import com.pe.iscastillo05.beans.Estudiante;

public interface EstudianteDAO {

	public Estudiante getById(int id);
	public List<Estudiante>getAll();
	public Estudiante create(Estudiante obj);
	public Estudiante update(Estudiante obj);
	public boolean delete(int id);
}
