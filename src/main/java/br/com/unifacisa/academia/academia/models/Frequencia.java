package br.com.unifacisa.academia.academia.models;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frequencia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private ArrayList<Long> frequencia = new ArrayList<Long>();
	private Date dia;
	
	
	public Frequencia() {
	}
	public Frequencia(Exercicio exercicio, ArrayList<Long> frequencia, Date dia) {
		super();
		this.frequencia = frequencia;
		this.dia = dia;
	}


	public void addId(Long id) {
		frequencia.add(id);
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
