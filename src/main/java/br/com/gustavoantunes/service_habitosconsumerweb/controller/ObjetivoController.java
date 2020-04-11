package br.com.gustavoantunes.service_habitosconsumerweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gustavoantunes.service_habitosconsumerweb.client.HabitosClient;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.MetaFormCadastroDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoFormCadastroDTO;

@Controller
@RequestMapping("/objetivo")
public class ObjetivoController {

	@Autowired
	private HabitosClient habitosClient;

	@GetMapping
	public ModelAndView listar(Model model) {

		List<ObjetivoDTO> objetivos = habitosClient.listar();
		model.addAttribute("objetivos", objetivos);
		
		return new ModelAndView("pages/objetivo/objetivos", model.asMap());
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrarObjetivo(Model model) {

		model.addAttribute("objetivo", new ObjetivoFormCadastroDTO());

		return new ModelAndView("pages/objetivo/objetivo-cadastrar", model.asMap());
	}

	@PostMapping
	public ModelAndView cadastrarObjetivo(Model model,
			@ModelAttribute("objetivo") ObjetivoFormCadastroDTO objetivoForm) {

//		ResponseEntity<ObjetivoDTO> response = client.postForEntity(
//				  "http://habitos/objetivo", objetivoForm , ObjetivoDTO.class);
		ObjetivoDTO objetivo = habitosClient.cadastrar(objetivoForm);
		model.addAttribute("objetivo", objetivo);
		model.addAttribute("meta", new MetaFormCadastroDTO());
		return new ModelAndView("meta-cadastrar", model.asMap());
	}

	@PostMapping("/meta")
	public ModelAndView cadastrarMeta(Model model, @ModelAttribute("meta") MetaFormCadastroDTO metaForm) {

		return null;
	}

}
