package com.sample;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;


@SuppressWarnings("restriction")
@Entity
public class Banca {
	@Id 
	@GeneratedValue(strategy = AUTO)
	private Integer idBanca;
	private String denumire, adresa, localitate;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="banca", orphanRemoval=true)
	private List<Credit> listaCredite = new ArrayList<Credit>();
	
	// Default constructor
	public Banca() {
		super();
	}
		
	// Add a new credit for the current bank
	public void addCredit(Credit credit) {
		listaCredite.add(credit);
		credit.setBanca(this);
	}
	
	// Remove a credit for the current bank
	public void removeCredit(Credit credit) {
		credit.setBanca(null);
		this.listaCredite.remove(credit);
	}
		
	// Getters & Setters
	public Integer getIdBanca() {
		return idBanca;
	}
	public void setIdBanca(Integer idBanca) {
		this.idBanca = idBanca;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getLocalitate() {
		return localitate;
	}
	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}
	public List<Credit> getListaCredite() {
		return listaCredite;
	}
	public void setListaCredite(List<Credit> listaCredite) {
		this.listaCredite = listaCredite;
	}
}

