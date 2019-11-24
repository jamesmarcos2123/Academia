package br.com.unifacisa.academia.academia.dto;

import java.util.Date;



public class ExercicioDto {

	
	private String nome;
	private Date horarioInicio;
	private Date horarioFinal;
	
	
	public ExercicioDto(String nome, Date horarioInicio, Date horarioFinal) {
		this.nome = nome;
		this.horarioInicio = horarioInicio;
		this.horarioFinal = horarioFinal;
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



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}
