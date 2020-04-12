package br.com.gustavoantunes.service_habitosconsumerweb.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoFormCadastroDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoFormEdtDTO;

@FeignClient("habitos")
public interface HabitosClient {

	@GetMapping("/objetivo")
	List<ObjetivoDTO> listar();

	@PostMapping("/objetivo")
	ObjetivoDTO cadastrar(ObjetivoFormCadastroDTO objetivoForm);

	@PutMapping("/objetivo/{id}")
	ObjetivoDTO atualizar(@PathVariable Long id, ObjetivoFormEdtDTO edt);
	
	@DeleteMapping("/objetivo/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id);
	
	@GetMapping("/objetivo/{id}")
	public ObjetivoDTO detalhar(@PathVariable Long id); 
}
