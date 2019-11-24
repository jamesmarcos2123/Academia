package br.com.unifacisa.academia.academia.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	private String cpf;
	@OneToMany
	private List<Exercicio> exercicios = new ArrayList<Exercicio>();
	
	
	public Aluno() {
		super();
	}
	public Aluno(String nome, Endereco endereco, String cpf, List<Exercicio> exercicios) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.exercicios = exercicios;
	}
	public void AddList(Exercicio exercicio) {
		exercicios.add(exercicio);
	}
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
	
}
