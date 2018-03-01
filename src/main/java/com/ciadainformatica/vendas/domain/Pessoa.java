package com.ciadainformatica.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial") // ignora warning deste tipo
@Entity // diz : que esta classe é uma entidade, é uma tabela
public class Pessoa extends GenericDomain {

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 80, nullable = false)
	private String rua;

	@Column(length = 80, nullable = false)
	private String bairro;

	@Column(length = 13, nullable = false)
	private String telefone;

	@Column(length = 14, nullable = false)
	private String celular;

	@Column(length = 100, nullable = false)
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
