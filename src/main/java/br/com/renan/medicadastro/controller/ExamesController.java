package br.com.renan.medicadastro.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.renan.medicadastro.dao.ExameDao;
import br.com.renan.medicadastro.dao.PacienteDao;
import br.com.renan.medicadastro.modelo.Exame;
import br.com.renan.medicadastro.modelo.Paciente;

@Controller
public class ExamesController {
	private ExameDao dao;
	private PacienteDao pacienteDao;

	@Autowired
	public ExamesController(ExameDao dao, PacienteDao pacienteDao) {
		this.dao = dao;
		this.pacienteDao = pacienteDao;
	}

	@RequestMapping("/cadastroExame")
	String getFormularioExame(Model model) throws SQLException {
		List<Paciente> pacientes = pacienteDao.lista();
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
		Paciente paciente = pacienteDao.getPaciente(idPaciente);

		exame.setPaciente(paciente);
		
		dao.adiciona(exame);
		return "forward:/listaExames";
	}

	@RequestMapping("alteraExame")
	String altera(HttpServletRequest req) throws ParseException, SQLException {
		Exame exame = new Exame();

		exame.setId(Long.parseLong(req.getParameter("id")));
		exame.setNome(req.getParameter("nome"));
		exame.setDescricao(req.getParameter("descricao"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(req.getParameter("data")));
		exame.setData(c);

		long idPaciente = Long.parseLong(req.getParameter("idPaciente"));
		Paciente paciente = pacienteDao.getPaciente(idPaciente);

		exame.setPaciente(paciente);
		dao.altera(exame);
		return "forward:listaExames";
		
	}

	@RequestMapping("/listaExames")
	String list(Model model) throws SQLException {
		List<Exame> exames = dao.lista();
		model.addAttribute("exames", exames);
		return "/exame/lista";
	}

	@RequestMapping("/mostraExame")
	String mostraExame(long id, Model model) throws SQLException {
		Exame exame = dao.getExame(id);
		List<Paciente> pacientes = pacienteDao.lista();
		model.addAttribute("exame", exame);
		model.addAttribute("pacientes", pacientes);
		return "/exame/formulario-alteracao";
	}

	@RequestMapping("/removeExame")
	String remove(Exame exame) throws SQLException {
		dao.remove(exame);
		return "forward:/listaExames";
	}

}
