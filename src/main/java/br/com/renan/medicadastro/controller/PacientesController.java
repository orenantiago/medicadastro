package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.renan.medicadastro.modelo.Paciente;
import br.com.renan.medicadastro.repository.PacienteRepository;

@CrossOrigin
@RestController
public class PacientesController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@RequestMapping(value = "/pacientes", method = RequestMethod.POST)
	public void addPaciente(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@RequestMapping(value = "/pacientes", method = RequestMethod.GET)
	public List<Paciente> list(Model model) throws SQLException {
		return pacienteRepository.findAll();
	}

	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable String id) throws SQLException {
		Paciente paciente = pacienteRepository.findOne(Long.parseLong(id));
		pacienteRepository.delete(paciente);
	}

	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET)
	public Paciente mostraPaciente(@PathVariable String id) throws SQLException {
		return pacienteRepository.findOne(Long.parseLong(id));
	}

	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.PUT)
	public void altera(@RequestBody Paciente paciente, @PathVariable String id) throws SQLException {
		Paciente oldPaciente = pacienteRepository.findOne(Long.parseLong(id));
		oldPaciente.setNome(paciente.getNome());
		oldPaciente.setIdade(paciente.getIdade());
		oldPaciente.setSexo(paciente.getSexo());
		pacienteRepository.save(oldPaciente);
	}
}
