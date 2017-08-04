package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		dao.adiciona(paciente);
		return "forward:listaPacientes";
	}
	
	@RequestMapping("/listaPacientes")
	public String list(Model model) throws SQLException {
		List <Paciente> pacientes = dao.lista();
		
		model.addAttribute("pacientes", pacientes);
		return "/paciente/lista";
	}
	
	@RequestMapping("/removePaciente")
	public String remove(Paciente paciente) throws SQLException {
		dao.remove(paciente);
		return "forward:listaPacientes";
	}
	
	@RequestMapping("/mostraPaciente")
	public String mostraPaciente(long id, Model model) throws SQLException {
		model.addAttribute("paciente", dao.getPaciente(id));
		return "/paciente/formulario-alteracao";
	}
	
	@RequestMapping("/alteraPaciente")
	public String altera(Paciente paciente) throws SQLException {
		dao.altera(paciente);
		return "forward:listaPacientes";
	}
}
