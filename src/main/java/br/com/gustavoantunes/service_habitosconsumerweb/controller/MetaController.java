package br.com.gustavoantunes.service_habitosconsumerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.gustavoantunes.service_habitosconsumerweb.client.HabitosClient;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.MetaDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.MetaFormCadastroDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoDTO;

@Controller
@RequestMapping("/meta")
public class MetaController {

	@Autowired
	private HabitosClient habitosClient;

	@GetMapping("/objetivo/{id}")
	public ModelAndView listar(Model model, @PathVariable Long id) {

		ObjetivoDTO objetivo = habitosClient.detalhar(id);
		model.addAttribute("objetivo", objetivo);
		model.addAttribute("meta", new MetaFormCadastroDTO(objetivo));

		return new ModelAndView("pages/meta/metas", model.asMap());
	}

	@PostMapping
	public ModelAndView cadastrarMeta(Model model, @ModelAttribute("objetivo") MetaFormCadastroDTO metaForm) {

		MetaDTO metaDTO = habitosClient.cadastrarMeta(metaForm);
		return new ModelAndView(new RedirectView("/meta/objetivo/" + metaDTO.getObjetivoId()), model.asMap());
	}

}
