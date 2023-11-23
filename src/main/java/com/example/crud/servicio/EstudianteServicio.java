package com.example.crud.servicio;

import java.util.List;

import com.example.crud.model.Estudiante;

public interface EstudianteServicio {
	
	public List<Estudiante> listarTodosLosEstudiantes();
	
	public Estudiante guardarEstudiante(Estudiante estudiante);

	public Estudiante obtenerEstudiantePorId(int id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudiante(int id);
}
