package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renan.medicadastro.dao.ExameRepository;
import br.com.renan.medicadastro.dao.PacienteRepository;
import br.com.renan.medicadastro.modelo.Exame;
import br.com.renan.medicadastro.modelo.Paciente;

@Controller
public class ExamesController {
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;

//	public ExamesController(ExameDao dao, PacienteDao pacienteDao) {
//		this.dao = dao;
//		this.pacienteDao = pacienteDao;
//	}

	@RequestMapping("/cadastroExame")
	String getFormularioExame(Model model) throws SQLException {
		List<Paciente> pacientes = pacienteRepository.findAll();
		model.addAttribute("pacientes", pacientes);
		return "/exame/formulario";
	}

	@RequestMapping(value = "/adicionaExame")
	String addExame(HttpServletRequest req) throws ParseException, SQLException {
		Exame exame = new Exame();

		exame.setNome(req.getParameter("nome"));
		exame.setDescricao(req.getParameter("descricao"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(req.getParameter("data")));
		exame.setData(c);

		long idPaciente = Long.parseLong(req.getParameter("idPaciente"));
		Paciente paciente = pacienteRepository.findOne(idPaciente);

		exame.setPaciente(paciente);
		
		exameRepository.save(exame);
		return "forward:/listaExames";
	}

	@RequestMapping("alteraExame")
	String altera(HttpServletRequest req) throws ParseException, SQLException {
		long id = Long.parseLong(req.getParameter("id"));
		Exame exame = exameRepository.findOne(id);

		exame.setNome(req.getParameter("nome"));
		exame.setDescricao(req.getParameter("descricao"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(req.getParameter("data")));
		exame.setData(c);

		long idPaciente = Long.parseLong(req.getParameter("idPaciente"));
		Paciente paciente = pacienteRepository.findOne(idPaciente);

		exame.setPaciente(paciente);
		exameRepository.save(exame);
		return "forward:listaExames";
		
	}

	@RequestMapping("/listaExames")
	String list(Model model) throws SQLException {
		List<Exame> exames = exameRepository.findAll();
		model.addAttribute("exames", exames);
		return "/exame/lista";
	}

	@RequestMapping("/mostraExame")
	String mostraExame(long id, Model model) throws SQLException {
		Exame exame = exameRepository.findOne(id);
		List<Paciente> pacientes = pacienteRepository.findAll();
		model.addAttribute("exame", exame);
		model.addAttribute("pacientes", pacientes);
		return "/exame/formulario-alteracao";
	}

	@RequestMapping("/removeExame")
	String remove(Exame exame) throws SQLException {
		exameRepository.delete(exame);
		return "forward:/listaExames";
	}

}
