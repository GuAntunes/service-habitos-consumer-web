package br.com.gustavoantunes.service_habitosconsumerweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gustavoantunes.service_habitosconsumerweb.client.HabitosClient;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoDTO;
import br.com.gustavoantunes.service_habitosconsumerweb.dto.ObjetivoFormCadastroDTO;

@Service
public class ObjetivoService {
	
	@Autowired
	private HabitosClient HabitosClient;
	
	public ObjetivoDTO cadastrarObjetivo(ObjetivoFormCadastroDTO objetivoForm) {
		return HabitosClient.cadastrar(objetivoForm);
	}
	
}
