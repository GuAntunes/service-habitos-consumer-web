package br.com.gustavoantunes.service_habitosconsumerweb.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ObjetivoDTO {
	private Long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;
	private LocalDate dataInicio;
	private LocalDate dataConclusao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
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
	
	
}