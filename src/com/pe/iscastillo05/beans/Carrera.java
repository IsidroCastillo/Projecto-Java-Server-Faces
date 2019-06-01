package com.pe.iscastillo05.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the carrera database table.
 * 
 */
@Entity
@NamedQuery(name="Carrera.findAll", query="SELECT c FROM Carrera c")
public class Carrera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarrera;

	private String nombre;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="carrera")
	private List<Estudiante> estudiantes;

	public Carrera() {
	}

	public int getIdCarrera() {
		return this.idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setCarrera(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setCarrera(null);

		return estudiante;
	}

}