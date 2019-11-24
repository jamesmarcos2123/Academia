package br.com.unifacisa.academia.academia.dto;

import java.util.Date;


public class CriarExercicio {

	private String nome;
	private Long Idprofessor;
	private Date horarioInicio;
	private Date horarioFinal;
	
	public CriarExercicio(String nome, Long professor, Date horarioInicio, Date horarioFinal) {
		this.nome = nome;
		this.Idprofessor = professor;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
	}

	public String getNome() {
		return nome;
	}

	public Long getProfessor() {
		return Idprofessor;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}
	
	
}
