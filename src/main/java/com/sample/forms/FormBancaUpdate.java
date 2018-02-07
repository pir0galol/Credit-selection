package com.sample.forms;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sample.persistence.*;

@ManagedBean
@SessionScoped
public class FormBancaUpdate {
	private Integer idUpdate;
	private String denumireUpdate;
	private String adresaUpdate;
	private String localitateUpdate;
	
	// Default constructor
	public FormBancaUpdate() {
		super();
	}
	
	// Getters & Setters
	public String getAdresaUpdate() {
		return adresaUpdate;
	}

	public void setAdresaUpdate(String adresaUpdate) {
		this.adresaUpdate = adresaUpdate;
	}

	public String getLocalitateUpdate() {
		return localitateUpdate;
	}

	public void setLocalitateUpdate(String localitateUpdate) {
		this.localitateUpdate = localitateUpdate;
	}

	public String getDenumireUpdate() {
		return denumireUpdate;
	}

	public void setDenumireUpdate(String denumireUpdate) {
		this.denumireUpdate = denumireUpdate;
	}

	public Integer getIdUpdate() {
		return idUpdate;
	}

	public void setIdUpdate(Integer idUpdate) {
		this.idUpdate = idUpdate;
	}
	
	// ------------------------------------------------------------------------------------------
	// --------------------------------- FETCHING @params for UPDATE ----------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings({ "unchecked", "static-access" })
	public String editBanca() {
		DatabaseOperations dbo = new DatabaseOperations();
		// Instantiate a new list for our parameters
		List<String> list = new ArrayList<String>();
		
		// Loading the parameter list from DatabaseOperations 
		list = dbo.getParameters();
		
		// Setting the parameters to our global vars
		this.setIdUpdate(Integer.parseInt(list.get(0)));
		this.setDenumireUpdate(list.get(1));
		this.setAdresaUpdate(list.get(2));
		this.setLocalitateUpdate(list.get(3));
		
		// Checking some..
//		System.out.println("Parametrul id este: " + this.getIdUpdate());
		return "formEditBanca.xhtml?faces-redirect=true";
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- UPDATE BANK DETAILS --------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("static-access")
	public String updateBanca() {
		DatabaseOperations dbo = new DatabaseOperations();
		dbo.updateBanca(this.getIdUpdate(),this.getDenumireUpdate(), this.getAdresaUpdate(), this.getLocalitateUpdate());
		return "formListBanci.xhtml?faces-redirect=true";
		
	}
}
