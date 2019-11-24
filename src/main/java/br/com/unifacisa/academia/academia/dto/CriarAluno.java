package br.com.unifacisa.academia.academia.dto;

import br.com.unifacisa.academia.academia.models.Endereco;

public class CriarAluno {

	private String nome;
	private Endereco endereco;
	private String cpf;
	
	public CriarAluno(String nome, Endereco endereco, String cpf) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

	
	
}
