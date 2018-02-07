package com.sample.forms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ValueChangeEvent;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Scoring;
import com.sample.SituatieFamiliala;
import com.sample.TipCredit;
import com.sample.persistence.DatabaseOperations;
import com.sample.MonedaCredit;
import com.sample.Banca;
import com.sample.Credit;
import com.sample.DomeniuActivitate;
import com.sample.OcupatieActuala;
import com.sample.SituatieLocativa;

@ManagedBean
@RequestScoped
public class FormCreditSelection {
	private Scoring scoring = new Scoring();
	private String selectedCredit, selectedMoneda, selectedDomeniu, selectedOcupatie, selectedSituatieFam, selectedSituatieLoc;
	private TipCredit[] listaCredite;
	private MonedaCredit[] listaMonede;
	private DomeniuActivitate[] listaDomenii;
	private OcupatieActuala[] listaOcupatii;
	private SituatieFamiliala[] listaSituatiiFam;
	private SituatieLocativa[] listaSituatiiLoc;
	private Map<Credit, Banca> mapResult = new LinkedHashMap<Credit, Banca>();
	private List<Entry<Credit, Banca>> entries;

	// Default constructor
	public FormCreditSelection() { super(); }
	
	// Getters & Setters
	public Scoring getScoring() {
		return scoring;
	}

	public void setScoring(Scoring scoring) {
		this.scoring = scoring;
	}

	public String getSelectedCredit() {
		return selectedCredit;
	}

	public void setSelectedCredit(String selectedCredit) {
		this.selectedCredit = selectedCredit;
	}
	
	public String getSelectedDomeniu() {
		return selectedDomeniu;
	}

	public void setSelectedDomeniu(String selectedDomeniu) {
		this.selectedDomeniu = selectedDomeniu;
	}

	public String getSelectedMoneda() {
		return selectedMoneda;
	}

	public void setSelectedMoneda(String selectedMoneda) {
		this.selectedMoneda = selectedMoneda;
	}
	
	public TipCredit[] getListaCredite() {
		this.listaCredite = TipCredit.values();
		return listaCredite;
	}

	public void setListaCredite(TipCredit[] listaCredite) {
		this.listaCredite = listaCredite;
	}

	public MonedaCredit[] getListaMonede() {
		this.listaMonede = MonedaCredit.values();
		return listaMonede;
	}

	public void setListaMonede(MonedaCredit[] listaMonede) {
		this.listaMonede = listaMonede;
	}
	
	public DomeniuActivitate[] getListaDomenii() {
		this.listaDomenii = DomeniuActivitate.values();
		return listaDomenii;
	}

	public void setListaDomenii(DomeniuActivitate[] listaDomenii) {
		this.listaDomenii = listaDomenii;
	}

	public String getSelectedOcupatie() {
		return selectedOcupatie;
	}
	
	public void setSelectedOcupatie(String selectedOcupatie) {
		this.selectedOcupatie = selectedOcupatie;
	}

	public OcupatieActuala[] getListaOcupatii() {
		this.listaOcupatii = OcupatieActuala.values();
		return listaOcupatii;
	}

	public void setListaOcupatii(OcupatieActuala[] listaOcupatii) {
		this.listaOcupatii = listaOcupatii;
	}
	
	public String getSelectedSituatieFam() {
		return selectedSituatieFam;
	}
	
	public void setSelectedSituatieFam(String selectedSituatieFam) {
		this.selectedSituatieFam = selectedSituatieFam;
	}
	
	public SituatieFamiliala[] getListaSituatiiFam() {
		this.listaSituatiiFam = SituatieFamiliala.values();
		return listaSituatiiFam;
	}

	public void setListaSituatiiFam(SituatieFamiliala[] listaSituatiiFam) {
		this.listaSituatiiFam = listaSituatiiFam;
	}

	public String getSelectedSituatieLoc() {
		return selectedSituatieLoc;
	}

	public void setSelectedSituatieLoc(String selectedSituatieLoc) {
		this.selectedSituatieLoc = selectedSituatieLoc;
	}

	public SituatieLocativa[] getListaSituatiiLoc() {
		this.listaSituatiiLoc = SituatieLocativa.values();
		return listaSituatiiLoc;
	}

	public void setListaSituatiiLoc(SituatieLocativa[] listaSituatiiLoc) {
		this.listaSituatiiLoc = listaSituatiiLoc;
	}
	
	public Map<Credit, Banca> getMapResult() {
		return mapResult;
	}

	public List<Entry<Credit, Banca>> getEntries() {
//		this.sort(entries);
		return entries;
	}
	
	public String returnToSelection() {
		return "formCreditSelection.xhtml?faces-redirect=true";
	}
	
	// ------------------------------------------------------------------------------------------
	// ----------------------------------- METHOD FOR SORTING THE ENTRYMAP --------------------------------------
	// ------------------------------------------------------------------------------------------
//	public void sort(List<Entry<Credit, Banca>> temp) {
//		
//		Collections.sort(temp, new Comparator<Map.Entry<Credit, Banca>>(){
//			@Override
//			public int compare(Entry<Credit, Banca> arg0, Entry<Credit, Banca> arg1) {
//				// TODO Auto-generated method stub
//				return arg0.getKey().getDAE().compareTo(arg1.getKey().getDAE());
//			}			
//		});
//	}
	
	
	// ------------------------------------------------------------------------------------------
	// ----------------------------------- EVENT LISTENERS --------------------------------------
	// ------------------------------------------------------------------------------------------
	public void currentCredit(ValueChangeEvent e) {
		try {
			if (e != null){
				this.selectedCredit = e.getNewValue().toString();
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
				this.selectedMoneda = e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	public void currentDomeniu(ValueChangeEvent e) {
		try {
			if (e != null){
				this.selectedDomeniu = e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	public void currentOcupatie(ValueChangeEvent e) {
		try {
			if (e != null){
				this.selectedOcupatie= e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	public void currentSituatieFam(ValueChangeEvent e) {
		try {
			if (e != null){
				this.selectedSituatieFam= e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	public void currentSituatieLoc(ValueChangeEvent e) {
		try {
			if (e != null){
				this.selectedSituatieLoc= e.getNewValue().toString();
			}
			else {
				e = null;
			}
		}
		catch(Exception ex) {
		}
	}
	
	// Redirect to banks list
		public String renunta() {
			return "formListBanci.xhtml?faces-redirect=true";
		}
		

	// ------------------------------------------------------------------------------------------
	// ----------------------------------- CHECKING THE IMPUTS ----------------------------------
	// ------------------------------------------------------------------------------------------
	private Boolean checkFields() {
		if (this.selectedCredit == null) return false;
		if (this.scoring.getValoareCredit() == 0 || this.scoring.getValoareCredit() == null) return false;
		if (this.scoring.getPerioadaCredit() == 0 || this.scoring.getPerioadaCredit() == null) return false;
		if (this.selectedMoneda == null) return false;
		if (this.scoring.getVenit() == 0 || this.scoring.getVenit() == null) return false;
		if (this.selectedDomeniu == null) return false;
		if (this.selectedOcupatie == null) return false;
		if (this.scoring.getVechime() == 0 || this.scoring.getVechime() == null) return false;
		if (this.scoring.getVarsta() == 0 || this.scoring.getVarsta() == null) return false;
		if (this.selectedSituatieFam == null) return false;
		if (this.selectedSituatieLoc == null) return false;
		return true;
	}
	
	// ------------------------------------------------------------------------------------------
	// ----------------------------------- RETRIEVE THE FINAL LIST ------------------------------
	// ------------------------------------------------------------------------------------------ 

	public String show() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		
		if (checkFields().booleanValue() == false) {
			return null;
		}
		else {
			Scoring s = new Scoring();
			List<Banca> listaBanci = new ArrayList<Banca>();
			listaBanci = DatabaseOperations.getAllBanks();
 
			s.setTipCredit(TipCredit.valueOf(this.selectedCredit));
			s.setValoareCredit(this.scoring.getValoareCredit());
			s.setPerioadaCredit(this.scoring.getPerioadaCredit());
			s.setMonedaCredit(MonedaCredit.valueOf(this.selectedMoneda));
			s.setVenit(this.scoring.getVenit());
			s.setDomeniuActivitate(DomeniuActivitate.valueOf(this.getSelectedDomeniu()));
			s.setOcupatieActuala(OcupatieActuala.valueOf(this.getSelectedOcupatie()));
			s.setVechime(this.scoring.getVechime());
			s.setVarsta(this.scoring.getVarsta());
			s.setSituatieFamiliala(SituatieFamiliala.valueOf(this.selectedSituatieFam));
			s.setSituatieLocativa(SituatieLocativa.valueOf(this.selectedSituatieLoc));
			
			kSession.insert(s);
			kSession.fireAllRules();
			
			if (s.isValid() == true) {
			for(Banca banca:listaBanci) {
				for(Credit credit:banca.getListaCredite()) {
					if (s.getTipCredit().equals(credit.getTipCredit())) {
						if (s.getScor() >= credit.getScor() &&
								s.getValoareCredit() <= credit.getValoareMax() &&
								s.getValoareCredit() >= credit.getValoareMin() &&
								s.getPerioadaCredit() <= credit.getPerioadaMax() &&
								s.getPerioadaCredit() >= credit.getPerioadaMin() &&
								s.getMonedaCredit().equals(credit.getMonedaCredit())) {
							System.out.println("Denumire banca: "+banca.getDenumire()+"\n "+ " Produs: "+credit.getDenumireCredit()+"\n "+" DAE: "+credit.getDAE());
							// Calculare prima rata
							credit.setPrimaRata(credit.calculPrimaRata(scoring.getValoareCredit(), scoring.getPerioadaCredit(), credit.getDAE()));
							// Calculare total plata
							credit.setTotalPlata(credit.calculTotalPlata(scoring.getValoareCredit(), scoring.getPerioadaCredit(), credit.getDAE()));
							// Rezultatul se adauga in map
							this.mapResult.put(credit, banca);							
						}
					}
				}
			}
		}	
	}	
		
		//Clearing the flash scope
		makeFlashScope(null);
		
		// Instantiating entries and setting it the values of
		// the EntrySet from "mapResult"
		this.entries = new ArrayList<>(this.getMapResult().entrySet());
				
		// Creating the flash scope
		makeFlashScope(this.entries);
		
		// Redirecting to the final page which will display the result
		return "formResults.xhtml?faces-redirect=true";
	}
	
	// Variables stored in the flash scope will survive a redirection 
	// and they will be discarded afterwards;
	// Useful when implementing a Post-Redirect-Get pattern. 
	private void makeFlashScope(List<Entry<Credit, Banca>> temp) {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("finalList", temp);
		flash.put("sumaSolicitata", scoring.getValoareCredit());
		flash.put("perioadaSolicitata", scoring.getPerioadaCredit());
		flash.put("moneda", scoring.getMonedaCredit());
	}
}
