package br.com.unifacisa.academia.academia.dto;

import java.util.ArrayList;
import java.util.Date;

public class FrequenciaDto {

	private ArrayList<Long> frequencia = new ArrayList<Long>();
	private Date dia;
	
	
	public FrequenciaDto(ArrayList<Long> frequencia, Date dia) {
		this.frequencia = frequencia;
		this.dia = dia;
	}
	public ArrayList<Long> getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(ArrayList<Long> frequencia) {
		this.frequencia = frequencia;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	
	
}
