package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renan.medicadastro.dao.ExameDao;
import br.com.renan.medicadastro.dao.PacienteDao;
import br.com.renan.medicadastro.modelo.Paciente;

@Controller
public class ExamesController {
	private ExameDao dao;
	
	@Autowired
	public ExamesController(ExameDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/cadastroExame")
	String getFormularioExame(Model model) throws SQLException {
		PacienteDao pacienteDao = new PacienteDao();
		List <Paciente> pacientes = pacienteDao.lista();
		model.addAttribute("pacientes", pacientes);
		return "/exame/formulario";
	}
	
	@RequestMapping("/adicionaExame")
	String addPaciente() {
		return "YEAH BYACH";
	}
	
}
