package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.renan.medicadastro.modelo.Exame;
import br.com.renan.medicadastro.modelo.Paciente;
import br.com.renan.medicadastro.repository.ExameRepository;
import br.com.renan.medicadastro.repository.PacienteRepository;

@CrossOrigin
@RestController
public class ExamesController {
	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@RequestMapping(value = "/exames", method = RequestMethod.POST)
	public void addExame(@RequestBody Exame exame) throws ParseException, SQLException {
		exameRepository.save(exame);
	}

	@RequestMapping(value = "/exames/{id}", method = RequestMethod.PUT)
	public void altera(@RequestBody Exame exame, @PathVariable String id) throws ParseException, SQLException {
		Exame oldExame = exameRepository.findOne(Long.parseLong(id));
		oldExame.setPaciente(exame.getPaciente());
		oldExame.setData(exame.getData());
		oldExame.setDescricao(exame.getDescricao());
		oldExame.setNome(exame.getNome());
		exameRepository.save(oldExame);
	}

	@RequestMapping(value = "/exames", method = RequestMethod.GET)
	List<Exame> list() throws SQLException {
		List<Exame> exames = exameRepository.findAll();
		return exames;
	}

	@RequestMapping(value = "/exames/{id}", method = RequestMethod.GET)
	public Exame mostraExame(@PathVariable String id) throws SQLException {
		Exame exame = exameRepository.findOne(Long.parseLong(id));
		List<Paciente> pacientes = pacienteRepository.findAll();
		return exame;
	}

	@RequestMapping(value = "/exames/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable String id) throws SQLException {
		exameRepository.delete(Long.parseLong(id));
	}

}
