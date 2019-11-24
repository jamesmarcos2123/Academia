package br.com.unifacisa.academia.academia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomeRua;
	private String bairo;
	private String cep;
	private Long numeroCasa;
	
	
	
	public Endereco() {
		super();
	}
	public Endereco(String nomeRua, String bairo, String cep, Long numeroCasa) {
		super();
		this.nomeRua = nomeRua;
		this.bairo = bairo;
		this.cep = cep;
		this.numeroCasa = numeroCasa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeRua() {
		return nomeRua;
	}
	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}
	public String getBairo() {
		return bairo;
	}
	public void setBairo(String bairo) {
		this.bairo = bairo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Long getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(Long numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
}
