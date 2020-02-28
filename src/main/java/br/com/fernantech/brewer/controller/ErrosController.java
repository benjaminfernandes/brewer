package br.com.fernantech.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrosController {

	@GetMapping("/404")
	public String paginaNaoEncontrada() {
		return "404";
	}
	
	@GetMapping("/505")
	public String erroServidor() {
		return "505";
	}
}
