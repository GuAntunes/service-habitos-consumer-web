package br.com.gustavoantunes.service_habitosconsumerweb.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoFormCadastroDTO;

@FeignClient("habitos")
public interface HabitosClient {
	
	@GetMapping("/objetivo")
	List<ObjetivoDTO> listar();
	
	@PostMapping("/objetivo")
	ObjetivoDTO cadastrar(ObjetivoFormCadastroDTO objetivoForm);
}
