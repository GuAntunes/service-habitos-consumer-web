package br.com.gustavoantunes.service_habitosconsumerweb.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class TarefaFormEdtDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@NotNull
	private String nome;
	private String descricao;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataConclusao;
	private String imagem;
	private Long metaId;

	public TarefaFormEdtDTO(MetaDTO meta) {
		metaId = meta.getId();
	}

	public TarefaFormEdtDTO() {
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

	public Long getMetaId() {
		return metaId;
	}

	public void setMetaId(Long metaId) {
		this.metaId = metaId;
	}

}
