package com.example.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Estudiante;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

}
