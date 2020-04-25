package br.com.gustavoantunes.service_habitosconsumerweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.gustavoantunes.service_habitosconsumerweb.client.HabitosClient;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.MetaDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.TarefaDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.TarefaFormCadastroDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.TarefaFormEdtDTO;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private HabitosClient habitosClient;

	@ResponseBody
	@GetMapping("/meta/{id}")
	public ResponseEntity<?> listar(Model model, @PathVariable Long id) {

		MetaDTO meta = habitosClient.detalharMeta(id);

		return new ResponseEntity<>(meta, HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping
	public ResponseEntity<?> cadastrarTarefa(Model model, @ModelAttribute("tarefa") TarefaFormCadastroDTO tarefaForm) {

		TarefaDTO tarefaDTO = habitosClient.cadastrarTarefa(tarefaForm);
		return new ResponseEntity<>(tarefaDTO, HttpStatus.OK);
	}

	@PostMapping("/remover/{id}")
	public ModelAndView deletarTarefa(Model model, @PathVariable("id") Long id) {

		TarefaDTO tarefa = habitosClient.detalharTarefa(id);

		habitosClient.removerTarefa(id);

		return new ModelAndView(new RedirectView("/tarefa/meta/" + tarefa.getMetaId()), model.asMap());
	}

	@PostMapping("/atualizar/{id}")
	public ModelAndView alterarTarefa(Model model, @PathVariable("id") Long id,
			@ModelAttribute("tarefa") TarefaFormEdtDTO tarefaForm) {

		TarefaDTO tarefaDTO = habitosClient.atualizarTarefa(id, tarefaForm);

		return new ModelAndView(new RedirectView("/tarefa/meta/" + tarefaDTO.getMetaId()), model.asMap());
	}

}
