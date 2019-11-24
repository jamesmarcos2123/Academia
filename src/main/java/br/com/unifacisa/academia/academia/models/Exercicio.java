package br.com.unifacisa.academia.academia.models;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Exercicio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;

	private Long professor;
	private Date horarioInicio;
	private Date horarioFinal;
	@OneToOne(cascade=CascadeType.PERSIST)
	private Frequencia frequencia;
	
	public Exercicio() {
	}
	
	public Exercicio(String nome, Long professor, Date horarioInicio, Date horarioFinal) {
		super();
		this.nome = nome;
		this.professor = professor;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
		frequencia = new Frequencia();
	}
	
	public Long getProfessor() {
		return professor;
	}
	public Long getId() {
		return id;
	}
	
	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public Date getHorarioFinal() {
		return horarioFinal;
	}
	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setProfessor(Long professor) {
		this.professor = professor;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	

	
}
