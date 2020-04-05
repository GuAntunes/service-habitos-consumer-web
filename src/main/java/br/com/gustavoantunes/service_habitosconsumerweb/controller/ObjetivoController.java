package br.com.gustavoantunes.service_habitosconsumerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.gustavoantunes.service_habitosconsumerweb.client.HabitosClient;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoFormCadastroDTO;

@Controller
@RequestMapping("/objetivo")
public class ObjetivoController {

//	@Autowired
//	private RestTemplate client;

	@Autowired
	private HabitosClient HabitosClient;

	@GetMapping
	public ModelAndView cadastrarObjetivo(Model model) {

		model.addAttribute("objetivo", new ObjetivoFormCadastroDTO());

		return new ModelAndView("objetivo-cadastrar", model.asMap());
	}

	@PostMapping
	public ModelAndView cadastrarObjetivo(Model model,
			@ModelAttribute("objetivo") ObjetivoFormCadastroDTO objetivoForm) {

//		ResponseEntity<ObjetivoDTO> response = client.postForEntity(
//				  "http://habitos/objetivo", objetivoForm , ObjetivoDTO.class);
		ObjetivoDTO cadastro = HabitosClient.cadastrar(objetivoForm);
		System.out.println(cadastro);
		return new ModelAndView("meta-cadastrar", model.asMap());
	}

}
