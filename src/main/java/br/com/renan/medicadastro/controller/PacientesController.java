package br.com.renan.medicadastro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renan.medicadastro.dao.PacienteDao;
import br.com.renan.medicadastro.modelo.Paciente;

@Controller
public class PacientesController {
	public PacienteDao dao;
	
	@Autowired
	public PacientesController(PacienteDao dao) {
		this.dao = dao;
	}
	
	//criar metodo para teste de dao
	
	@RequestMapping("/cadastroPaciente")
	public String getFormularioPaciente() {
		return "/paciente/formulario";
	}
	
	@RequestMapping("/adicionaPaciente")
	public String addPaciente(Paciente paciente) {
//		Paciente paciente = new Paciente();
//		paciente.setNome("renan");
//		paciente.setIdade(21);
//		paciente.setSexo("masculino");
		dao.adiciona(paciente);
		return "forward:listaPacientes";
	}
	
	@RequestMapping("/listaPacientes")
	public String list( ) {
		return "/paciente/lista";
	}
}
