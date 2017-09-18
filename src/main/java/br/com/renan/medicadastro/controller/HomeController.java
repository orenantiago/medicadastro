package br.com.renan.medicadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
public class HomeController {

	@RequestMapping("/")
	String home() {
		return "/home";
	}
}
