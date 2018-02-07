package com.sample;

public enum OcupatieActuala {

	CONDUCERE ("Functie de conducere"),
	CALIFICAT_CU_SS("Personal calificat cu studii superioare"),
	CALIFICAT_FARA_SS ("Personal calificat fara studii superioare"),
	NICIUNA ("Persoana care realizeaza venituri din activitatea agricola si care nu se incadreaza in niciuna din categoriile de mai sus");

	private String label;
	OcupatieActuala (String label){
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
