package com.sample;

public enum DomeniuActivitate {

	FINANCIAR ("Institutii financiare, bancare, societati de asigurare"),
	SERVICII ("Servicii si comert"),
	INDUSTRIE ("Industrie si constructii"),
	AGRICULTURA ("Agricultura");
	
	private String label;
	
	DomeniuActivitate(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
