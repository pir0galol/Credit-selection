package com.sample;

public class Scoring {

	private TipCredit tipCredit;
	private Integer valoareCredit;
	private Integer perioadaCredit;
	private MonedaCredit monedaCredit;
	private Integer venit;
	private DomeniuActivitate domeniuActivitate;
	private OcupatieActuala ocupatieActuala;
	private Integer vechime;
	private Integer varsta;
	private SituatieFamiliala situatieFamiliala;
	private SituatieLocativa situatieLocativa;
	private Integer scor = 0;
	private Boolean isValid;
		
	public Boolean checkScor() {
		if (scor > 30) {
			return true;
		}
		return false;
	}
		
	
	public Scoring() {
		super();
	}

	public TipCredit getTipCredit() {
		return tipCredit;
	}
	
	public void setTipCredit(TipCredit tipCredit) {
		this.tipCredit = tipCredit;
	}
	
	public Integer getValoareCredit() {
		return valoareCredit;
	}
	
	public void setValoareCredit(Integer valoareCredit) {
		this.valoareCredit = valoareCredit;
	}
	
	public Integer getPerioadaCredit() {
		return perioadaCredit;
	}

	public void setPerioadaCredit(Integer perioadaCredit) {
		this.perioadaCredit = perioadaCredit;
	}

	public MonedaCredit getMonedaCredit() {
		return monedaCredit;
	}

	public void setMonedaCredit(MonedaCredit monedaCredit) {
		this.monedaCredit = monedaCredit;
	}

	public Boolean isValid() {
		return isValid;
	}

	public void setValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	public Integer getScor() {
			return scor;
	}

	public void setScor(Integer scor) {
		this.scor = this.scor + scor;
	}
	

	public Integer getVenit() {
		return venit;
	}


	public void setVenit(Integer venit) {
		this.venit = venit;
	}

	public DomeniuActivitate getDomeniuActivitate() {
		return domeniuActivitate;
	}

	public void setDomeniuActivitate(DomeniuActivitate domeniuActivitate) {
		this.domeniuActivitate = domeniuActivitate;
	}

	public OcupatieActuala getOcupatieActuala() {
		return ocupatieActuala;
	}

	public void setOcupatieActuala(OcupatieActuala ocupatieActuala) {
		this.ocupatieActuala = ocupatieActuala;
	}

	public Integer getVechime() {
		return vechime;
	}

	public void setVechime(Integer vechime) {
		this.vechime = vechime;
	}

	public Integer getVarsta() {
		return varsta;
	}

	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}

	public SituatieFamiliala getSituatieFamiliala() {
		return situatieFamiliala;
	}

	public void setSituatieFamiliala(SituatieFamiliala situatieFamiliala) {
		this.situatieFamiliala = situatieFamiliala;
	}

	public SituatieLocativa getSituatieLocativa() {
		return situatieLocativa;
	}

	public void setSituatieLocativa(SituatieLocativa situatieLocativa) {
		this.situatieLocativa = situatieLocativa;
	}
}
