package com.sample;

public enum SituatieLocativa {

	PROPRIETATE("Proprietate"),
	PARINTI("Parinti, copii, alte rude si afini"),
	CHIRIE("Chirie fond locativ de stat"),
	PARTICULAR("Particular cu sau fara plata chiriei");
	
	private String label;
	SituatieLocativa(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
