package com.example.crud.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.crud.model.Estudiante;
import com.example.crud.servicio.EstudianteServicio;

@Controller
public class EstudianteController {
	
	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping({"/estudiantes", "/"})
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "estudiantes";
	}
	
	@GetMapping("/estudiantes/nuevo")
	public String crearEstudianteFormulario(Model modelo) {
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crearEstudiante";
	}
	
	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}
	
	
	//Elimina un estudiante
	
	@GetMapping("/estudiantes/{id}")
	public String delete(@PathVariable int id){
		Estudiante e = servicio.obtenerEstudiantePorId(id);
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	
	//Muestra el formulario de editar
		@GetMapping("/estudiantes/editar/{id}")
		public String mostrarFormularioEditar(@PathVariable int id, Model modelo){
			modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
			return "editarEstudiante";
		}
		
		//Modifica un estudiante segun su id
		
		@PostMapping("/estudiantes/{id}")
		public String update (@PathVariable int id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo){
			Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
			estudianteExistente.setId(id);
			estudianteExistente.setNombre(estudiante.getNombre());
			estudianteExistente.setApellido(estudiante.getApellido());
			estudianteExistente.setEmail(estudiante.getEmail());
			servicio.actualizarEstudiante(estudianteExistente);
			return "redirect:/estudiantes";
		}

}
