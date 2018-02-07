package com.sample.forms;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sample.Banca;
import com.sample.Credit;
import com.sample.persistence.*;

@ManagedBean
@ViewScoped
public class FormBanca implements IMessage{
	private Banca banca = new Banca();
	private List<Banca> listaBanci = new ArrayList<Banca>();
	private List<Credit> listaCredite = new ArrayList<>();
	private Integer idUpdate;
	private Boolean visible;
	
	
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	// Default constructor
	public FormBanca() {
		super();
	}
	
	// Getters & Setters
	public List<Credit> getListaCredite() {
		return listaCredite;
	}

	public Integer getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(Integer idUpdate) {
		this.idUpdate = idUpdate;
	}

	public Banca getBanca() {
		return banca;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------- GET ALL BANKS --------------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public List<Banca> getListaBanci() {
		DatabaseOperations dbo = new DatabaseOperations();
		this.listaBanci = dbo.getAllBanks();
		return listaBanci;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------- ADD A NEW BANK -------------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public String addBanca() {
		DatabaseOperations dbo = new DatabaseOperations();		
		if (valid().booleanValue() == false) {
			return null;
		}
		else {
			dbo.addBanca(banca);
			isSuccessful();
			banca = new Banca();
			return "formAddBanca.xhtml?faces-redirect=true";
		}
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- REMOVE A BANK --------------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public String removeBanca() {
		DatabaseOperations dbo = new DatabaseOperations();
		dbo.removeBanca(banca);
		this.setVisible(false);
		isBancaRemoved();
		return "formListBanci.xhtml?faces-redirect=true";
	}
	
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------- REDIRECT (formAddBanca.xhtml) ----------------------------
	// ------------------------------------------------------------------------------------------
	public String addNewBank() {
		return "formAddBanca.xhtml?faces-redirect=true";
	}
	

	// ------------------------------------------------------------------------------------------
	// -------------------------------- RETURN (to formListaBanci.xhtml) ------------------------
	// ------------------------------------------------------------------------------------------
	public String renuntaEdit() {
		return "formListBanci.xhtml?faces-redirect=true";
	}

	// ------------------------------------------------------------------------------------------
	// ---------------------------------- GET CREDITS FOR BANK @X -------------------------------
	// ------------------------------------------------------------------------------------------
	public void list(ActionEvent event) {
		// Fetching the UI attribute to banca_
		Banca banca_ = (Banca)event.getComponent().getAttributes().get("selected");
		this.listaCredite = DatabaseOperations.lista(banca_.getIdBanca());
		if (listaCredite == null) {
			System.out.println("Aceasta banca nu are niciun credit. Sadly.");
			return;
		}else {
			this.setVisible(true);
//			for(Credit c:listaCredite) {
//				System.out.println("Lista:\n"+c.getDenumireCredit());
//			}
		}
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- REMOVE A SPECIFIED CREDIT---------------------------
	// ------------------------------------------------------------------------------------------
	public String removeCredit(ActionEvent event) {
		Credit credit_ = (Credit)event.getComponent().getAttributes().get("selectedCredit");
		DatabaseOperations.removeCredit(credit_);
		this.setVisible(false);
		isCreditRemoved();
		return "formListBanci.xhtml?faces-redirect=true";
	}
	
	
	
	// ------------------------------------------------------------------------------------------
	// ---------------------------------- HIDE DATATABLE METHOD-------------------------------
	// ------------------------------------------------------------------------------------------
	public void hide(ActionEvent event) {
		this.setVisible(false);
	}
	
	// ------------------------------------------------------------------------------------------
	// ---------------------------------- VALIDATE INPUT FIELDS ---------------------------------
	// ------------------------------------------------------------------------------------------
	public Boolean valid() {
		if (this.banca.getDenumire() == null || this.banca.getDenumire().isEmpty()) {
			return false;
		}
		if (this.banca.getAdresa() == null || this.banca.getAdresa().isEmpty()) {
			return false;
		}
		if (this.banca.getLocalitate() == null || this.banca.getLocalitate().isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void addCredit(Credit credit) {
		this.banca.getListaCredite().add(credit);
		credit.setBanca(this.banca);
	}
	
	public void removeCredit(Credit credit) {
		credit.setBanca(null);
		this.banca.getListaCredite().remove(credit);
	}

	@Override
	public void isSuccessful() {
		// TODO Auto-generated method stub
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Succes! Ati adaugat banca.", null));
	}
	
	public void isCreditRemoved() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Ati sters creditul.", null));
	}
	
	public void isBancaRemoved() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Ati sters banca si toate creditele ei ;(", null));
	}
}
