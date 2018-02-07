package com.sample;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@SuppressWarnings("restriction")
@Entity
public class Credit{	
	@Id 
	@GeneratedValue(strategy = AUTO)
	private Integer idCredit;
	private Integer valoareMin, valoareMax, perioadaMin, perioadaMax, scor;
	@Enumerated(EnumType.STRING)
	private TipCredit tipCredit;
	private String denumireCredit;
	private Float DAE;
	@Transient
	private Float primaRata;
	@Transient
	private Float totalPlata;
	@Enumerated(EnumType.STRING)
	private MonedaCredit monedaCredit;
	@ManyToOne
	private Banca banca;
	
	// Default constructor
	public Credit() {
		super();
	}
	
	
	// Calculate the first rate
	public Float calculPrimaRata(Integer suma_, Integer perioada_, Float dae_) {
		try {
			Float rataFixa = (float)suma_/(perioada_*12);
			Float dobandaL = ((float)suma_*dae_/100*30)/360;
			Float rataL1 = rataFixa+dobandaL;
			return rataL1;
		}
		catch(Exception ex) {
			//
		}
		return 0F;
	}
	
	// Calculate total return
	public Float calculTotalPlata(Integer suma_, Integer perioada_, Float dae_) {
		Integer sold = suma_;
		Float ratan, dobanda;		
		// Cunoastem prima rata		
		Float rata1 = this.getPrimaRata();		
		// Stiind prima rata, ea se va adauga la totalul de plata
		Float total = rata1;		
		// Rata fixa
		Float rataFixa = (float)suma_/(perioada_*12);		
		try {
			// Sigur ca pornim de la 2 fiindca pt prima luna stim deja..
			for (int i=2; i<=perioada_*12; ++i) {				
				// Diminuam soldul
				sold = (int)(sold - rataFixa);
				// Calculam noua dobanda pt urmatoarea luna
				dobanda = (sold*dae_/100*30)/360;
				// Calculam rata noua pt urmatoarea luna (n)
				ratan = rata1 + dobanda;
				// Solutionam totalul de plata
				total += ratan;
			}			
			return total;
		}
		catch(Exception ex) {
			//
		}
		return 0F;
	}
	
	public Float getPrimaRata() {
		return primaRata;
	}

	public void setPrimaRata(Float primaRata) {
		this.primaRata = primaRata;
	}
	
	

	public Float getTotalPlata() {
		return totalPlata;
	}


	public void setTotalPlata(Float totalPlata) {
		this.totalPlata = totalPlata;
	}


	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public Integer getIdCredit() {
		return idCredit;
	}

	public void setIdCredit(Integer idCredit) {
		this.idCredit = idCredit;
	}
	
	public TipCredit getTipCredit() {
		return tipCredit;
	}

	public void setTipCredit(TipCredit tipCredit) {
		this.tipCredit = tipCredit;
	}

	public String getDenumireCredit() {
		return denumireCredit;
	}

	public void setDenumireCredit(String denumireCredit) {
		this.denumireCredit = denumireCredit;
	}

	public Float getDAE() {
		return DAE;
	}

	public void setDAE(Float dAE) {
		DAE = dAE;
	}

	public Integer getValoareMin() {
		return valoareMin;
	}

	public void setValoareMin(Integer valoareMin) {
		this.valoareMin = valoareMin;
	}

	public Integer getValoareMax() {
		return valoareMax;
	}

	public void setValoareMax(Integer valoareMax) {
		this.valoareMax = valoareMax;
	}

	public Integer getPerioadaMin() {
		return perioadaMin;
	}

	public void setPerioadaMin(Integer perioadaMin) {
		this.perioadaMin = perioadaMin;
	}

	public Integer getPerioadaMax() {
		return perioadaMax;
	}

	public void setPerioadaMax(Integer perioadaMax) {
		this.perioadaMax = perioadaMax;
	}

	public MonedaCredit getMonedaCredit() {
		return monedaCredit;
	}

	public void setMonedaCredit(MonedaCredit monedaCredit) {
		this.monedaCredit = monedaCredit;
	}

	public Integer getScor() {
		return scor;
	}

	public void setScor(Integer scor) {
		this.scor = scor;
	}	
}
