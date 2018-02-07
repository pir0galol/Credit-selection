package com.sample;

public enum TipCredit {
	NEVOIPERSONALE("Nevoi personale"),
	IMOBILIAR("Imobiliar"),
	AUTO("Auto");
	
	private String label;
	
	private TipCredit(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
