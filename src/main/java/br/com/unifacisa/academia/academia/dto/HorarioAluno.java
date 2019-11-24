package br.com.unifacisa.academia.academia.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.unifacisa.academia.academia.models.Exercicio;

public class HorarioAluno {
	
	private String nome;
	private List<ExercicioDto> exercicios = new ArrayList<ExercicioDto>();


	public HorarioAluno(String nome , List<Exercicio> exercicios) {
		this.nome = nome;
		for (Exercicio exercicio : exercicios) {
			this.exercicios.add(new ExercicioDto(exercicio.getNome(),exercicio.getHorarioInicio(),exercicio.getHorarioFinal()));
		}
	}
	public List<ExercicioDto> getExercicios() {
		return exercicios;
	}
	public String getNome() {
		return nome;
	}
	
}
