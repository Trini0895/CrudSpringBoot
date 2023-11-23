package com.example.crud.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Access(AccessType.FIELD)
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "nombre", nullable = false, unique = false)
	public String nombre;
	
	@Column(name = "apellido", nullable = false, unique = false)
	public String apellido;
	
	@Column(name = "email", nullable = false, unique = false)
	public String email;
	
}
