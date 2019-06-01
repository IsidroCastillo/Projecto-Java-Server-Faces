package com.pe.iscastillo05.jsf;

import java.util.List;

import com.pe.iscastillo05.beans.Estudiante;
import com.pe.iscastillo05.dao.EstudianteDAO;
import com.pe.iscastillo05.impl.EstudianteDAOImpl;

public class EstudianteBean {

	private EstudianteDAO dao = new EstudianteDAOImpl();
	private Estudiante estudiante = new Estudiante();

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String newEstudiante() {
		this.estudiante = new Estudiante();
		return "NewEstudiante.xhtml?faces-redirect=true";
	}

	public String editEstudiante() throws Exception {
		int editId = this.estudiante.getId();
		this.estudiante = new Estudiante();
		this.estudiante = dao.getById(editId);
		return "EstudianteEdit.xhtml?faces-redirect=true";
	}

	public String deleteEstudiante()throws Exception {
		int deleteId = this.estudiante.getId();
		this.estudiante = new Estudiante();
		dao.delete(deleteId);
		return "Estudiante_List.xhtml?faces-redirect=true";
	}

	public List<Estudiante> getAll() {
		try {
			List<Estudiante> list = dao.getAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String create() throws Exception {
		dao.create(estudiante);
		return "Estudiante_List.xhtml?faces-redirect=true";
	}

	public String update() throws Exception {
		dao.update(estudiante);
		return "Estudiante_List.xhtml?faces-redirect=true";
	}
}
