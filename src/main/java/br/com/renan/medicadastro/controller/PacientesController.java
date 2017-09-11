package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renan.medicadastro.modelo.Paciente;
import br.com.renan.medicadastro.repository.PacienteRepository;

@Controller
public class PacientesController {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	//criar metodo para teste de dao
	
	@RequestMapping("/cadastroPaciente")
	public String getFormularioPaciente() {
		return "/paciente/formulario";
	}
	
	@RequestMapping("/adicionaPaciente")
	public String addPaciente(Paciente paciente) {
		pacienteRepository.save(paciente);
		return "forward:listaPacientes";
	}
	
	@RequestMapping("/listaPacientes")
	public String list(Model model) throws SQLException {
		List <Paciente> pacientes = pacienteRepository.findAll();
		
		model.addAttribute("pacientes", pacientes);
		return "/paciente/lista";
	}
	
	@RequestMapping("/removePaciente")
	public String remove(Paciente paciente) throws SQLException {
		pacienteRepository.delete(paciente);
		return "forward:listaPacientes";
	}
	
	@RequestMapping("/mostraPaciente")
	public String mostraPaciente(long id, Model model) throws SQLException {
		model.addAttribute("paciente", pacienteRepository.findOne(id));
		return "/paciente/formulario-alteracao";
	}
	
	@RequestMapping("/alteraPaciente")
	public String altera(Paciente paciente) throws SQLException {
		Paciente oldPaciente = pacienteRepository.findOne(paciente.getId());
		oldPaciente.setIdade(paciente.getIdade());
		oldPaciente.setNome(paciente.getNome());
		oldPaciente.setSexo(paciente.getSexo());
		pacienteRepository.save(paciente);
		return "forward:listaPacientes";
	}
}
