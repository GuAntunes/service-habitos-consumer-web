package br.com.gustavoantunes.service_habitosconsumerweb.dto;

import java.time.LocalDate;

public class ObjetivoFormCadastroDTO {

	private String nome;
	private String descricao;
	private LocalDate dataInicio;
	private LocalDate dataConclusao;
	private String imagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
