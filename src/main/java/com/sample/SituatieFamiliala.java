package com.sample;

public enum SituatieFamiliala {

	CASATORIT_MAX_2PERS("Casatorit/a cu cel mult 2 persoane in familie care nu realizeaza venituri"),
	CASATORIT_MIN_2PERS("Casatorit/a cu mai mult de 2 persoane in familie care nu realizeaza venituri"),
	NECASATORIT_MAX_2PERS("Necasatorit/a, divortat/a, vaduv/a cu cel mult 2 persoane in familie care nu realizeaza venituri"),
	NECASATORIT_MIN_2PERS("Necasatorit/a, divortat/a, vaduv/a cu mai mult de 2 persoane in familie care nu realizeaza venituri");

	private String label;
	SituatieFamiliala (String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
