package br.com.renan.medicadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PacienteController {
	
	@RequestMapping("/cadastroPaciente")
	public String getFormularioPaciente() {
		return "/paciente/formulario-paciente";
	}
	
	@RequestMapping("/adicionaPaciente")
	public String addPaciente() {
		return "Paciente adicionado";
	}
}
