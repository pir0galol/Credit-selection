package com.sample.forms;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.sample.Credit;
import com.sample.TipCredit;
import com.sample.MonedaCredit;
import com.sample.Banca;
import com.sample.persistence.*;

@ManagedBean
@ViewScoped
public class FormCredit implements IMessage{
	private Credit credit = new Credit();
	private String denumireBanca, tipCredit, monedaCredit, bancaCurenta;
	private TipCredit[] lista;
	private MonedaCredit[] listaMoneda;
	private List<Banca> listaDenumireBanci = new ArrayList<Banca>();
	
	// Default constructor
	public FormCredit() {
		super();
	}
	
	// Getters and Setters
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}
	public String getDenumireBanca() {
		return denumireBanca;
	}
	public void setDenumireBanca(String denumireBanca) {
		this.denumireBanca = denumireBanca;
	}

	public TipCredit[] getLista() {
		this.lista = TipCredit.values();
		return lista;
	}
	
	public MonedaCredit[] getListaMoneda() {
		this.listaMoneda = MonedaCredit.values();
		return listaMoneda;
	}

	public String getTipCredit() {
		return tipCredit;
	}

	public void setTipCredit(String tipCredit) {
		this.tipCredit = tipCredit;
	}
	
	public String getMonedaCredit() {
		return monedaCredit;
	}

	public void setMonedaCredit(String monedaCredit) {
		this.monedaCredit = monedaCredit;
	}

	public String getBancaCurenta() {
		return bancaCurenta;
	}

	public void setBancaCurenta(String bancaCurenta) {
		this.bancaCurenta = bancaCurenta;
	}

	
	// Redirect to Create-Credit page
	public String goToCredits() {
		return "formCreateCredit.xhtml?faces-redirect=true";
	}
	
	
	// ------------------------------------------------------------------------------------------
	// ----------------------------- GET ALL BANKS NAMES FOR COMBOBOX ---------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public List<Banca> getListaDenumireBanci() {
		DatabaseOperations dbo = new DatabaseOperations();
		this.listaDenumireBanci = dbo.getDenumireBanci();
		return listaDenumireBanci;
	}

	// ------------------------------------------------------------------------------------------
	// -----------------------------------EVENT LISTENERS ---------------------------------------
	// ------------------------------------------------------------------------------------------
	public void currentCredit(ValueChangeEvent e) {
		try {
			if (e != null){
				this.tipCredit = e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	public void currentMoneda(ValueChangeEvent e) {
		try {
			if (e != null){
				this.monedaCredit = e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
		
	}
	public void currentBanca(ValueChangeEvent e) {
		try {
			if (e != null){
				this.bancaCurenta = e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- CREATE A NEW CREDIT --------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public void addCredit() {	
		DatabaseOperations dbo = new DatabaseOperations();
		// Searching for the bank's name we've selected in the interface 
		List<Banca> objectBanca = dbo.getBancaObject(this.getBancaCurenta());
		// Asigning the list result to a Banca type variable named "b"
		Banca b = objectBanca.get(0);
		
		try {
			// Checking for nulls/0 values
			Boolean valid = CheckFields();
			if (valid == true) {
				dbo.addCredit(this.getTipCredit(), this.credit.getDenumireCredit(), this.credit.getDAE(), this.credit.getValoareMin(),
						this.credit.getValoareMax(), this.credit.getPerioadaMin(), this.credit.getPerioadaMax(),
						this.getMonedaCredit(), this.credit.getScor(), b);
				isSuccessful();
				credit = new Credit();
			} 
		}
		catch(Exception ex) {
			System.out.println("Nu s-au completat toate campurile in mod corespunzator. Berbecule/Oaio!");
		}
	}
	

	// ------------------------------------------------------------------------------------------
	// ------------------------------------- CHECKING FIELDS VALUES -----------------------------
	// ------------------------------------------------------------------------------------------
	private Boolean CheckFields() {
		if (this.getTipCredit() == null) return false;
		if (this.credit.getDenumireCredit() == null) return false;
		if (this.credit.getDAE() == 0F || this.credit.getDAE() == null) return false;
		if (this.credit.getValoareMin() == 0 || this.credit.getValoareMin() == null) return false;
		if (this.credit.getValoareMax() == 0 || this.credit.getValoareMax() == null) return false;
		if (this.credit.getPerioadaMin() == 0 || this.credit.getPerioadaMin() == null) return false;
		if (this.credit.getPerioadaMax() == 0 || this.credit.getPerioadaMax() == null) return false;
		if (this.getMonedaCredit() == null) return false;
		if (this.credit.getScor() == 0 || this.credit.getScor() == null) return false;
		return true;		
	}
	// Redirect to banks list
	public String renunta() {
		return "formListBanci.xhtml?faces-redirect=true";
	}

	@Override
	public void isSuccessful() {
		// TODO Auto-generated method stub
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Succes! Ati inserat creditul.", null));
	}
}
