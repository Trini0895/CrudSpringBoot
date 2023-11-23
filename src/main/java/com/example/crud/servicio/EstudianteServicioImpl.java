package com.example.crud.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dao.EstudianteRepositorio;
import com.example.crud.model.Estudiante;

@Service
public class EstudianteServicioImpl implements EstudianteServicio{
	
	@Autowired
	private EstudianteRepositorio estudianteRepositorio;

	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {
		
		return estudianteRepositorio.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return estudianteRepositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantePorId(int id) {
		return estudianteRepositorio.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return estudianteRepositorio.save(estudiante);
	}

	@Override
	public void eliminarEstudiante(int id) {
		estudianteRepositorio.deleteById(id);
	}

}
