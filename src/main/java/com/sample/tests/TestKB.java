package com.sample.tests;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.util.List;
import java.util.ArrayList;
import com.sample.*;

public class TestKB{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
//		Scoring s = new Scoring (TipCredit.NEVOIPERSONALE, 22000, 20, MonedaCredit.RON, 6500,DomeniuActivitate.FINANCIAR, OcupatieActuala.CONDUCERE, 6, 30, SituatieFamiliala.CASATORIT_MAX_2PERS, SituatieLocativa.PROPRIETATE, 0, false);
//		Scoring s = new Scoring(TipCredit.NEVOIPERSONALE, 25000, 36, MonedaCredit.EUR, 500, DomeniuActivitate.AGRICULTURA, OcupatieActuala.NICIUNA, 1, 80, SituatieFamiliala.NECASATORIT_MIN_2PERS, SituatieLocativa.PARTICULAR, 0, false);
		
		Scoring s = new Scoring();
		s.setTipCredit(TipCredit.NEVOIPERSONALE);
		s.setValoareCredit(22000);
		s.setPerioadaCredit(20);
		s.setMonedaCredit(MonedaCredit.RON);
		s.setVenit(6500);
		s.setDomeniuActivitate(DomeniuActivitate.FINANCIAR);
		s.setOcupatieActuala(OcupatieActuala.CONDUCERE);
		s.setVechime(6);
		s.setVarsta(30);
		s.setSituatieFamiliala(SituatieFamiliala.CASATORIT_MAX_2PERS);
		s.setSituatieLocativa(SituatieLocativa.PROPRIETATE);
		
		kSession.insert(s);
		kSession.fireAllRules();
		
		// Banca Alfa
//		Credit c1 = new Credit(TipCredit.NEVOIPERSONALE, "Banca Alfa - Creditul de nevoi personale", 9.5f, 250, 25000, 1, 25, MonedaCredit.RON, 45);
//		Credit c2 = new Credit(TipCredit.IMOBILIAR, "Banca Alfa - Creditul imobiliar", 10.22f, 85000, 450000, 1, 25, MonedaCredit.RON, 45);
//		Credit c3 = new Credit(TipCredit.AUTO, "Banca Alfa - Creditul AUTO", 13.55f, 65000, 250000, 1, 24, MonedaCredit.RON, 45);
//
//		List<Credit> listaAlfa = new ArrayList<Credit>();
//		listaAlfa.add(c1);
//		listaAlfa.add(c2);
//		listaAlfa.add(c3);
//		
//		// Banca Beta
//		Credit c4 = new Credit(TipCredit.NEVOIPERSONALE, "Banca Beta - Creditul de nevoi personale", 9.6f, 180, 22000, 1, 20, MonedaCredit.RON, 44);
//		Credit c5 = new Credit(TipCredit.IMOBILIAR, "Banca Beta - Creditul imobiliar", 10.66f, 46000, 980000, 1, 35, MonedaCredit.RON, 50);
//		Credit c6 = new Credit(TipCredit.AUTO, "Banca Beta - Creditul AUTO", 15.05f, 100000,  720000, 1, 25, MonedaCredit.RON, 42);
//
//		List<Credit> listaBeta = new ArrayList<Credit>();
//		listaBeta.add(c4);
//		listaBeta.add(c5);
//		listaBeta.add(c6);
//				
//		// Banca Teta
//		Credit c7 = new Credit(TipCredit.NEVOIPERSONALE, "Banca Teta - Creditul de nevoi personale", 10f, 100, 15000, 1, 22, MonedaCredit.RON, 43);
//		Credit c8 = new Credit(TipCredit.IMOBILIAR, "Banca Teta - Creditul imobiliar", 16.35f, 225000, 665000, 1, 25, MonedaCredit.RON, 42);
//		Credit c9 = new Credit(TipCredit.AUTO, "Banca Teta - Creditul AUTO", 14.55f, 150000, 650000, 1, 20, MonedaCredit.RON, 42);
//
//		List<Credit> listaTeta = new ArrayList<Credit>();
//		listaTeta.add(c7);
//		listaTeta.add(c8);
//		listaTeta.add(c9);
//
//		Banca b = new Banca ("Banca Alfa", "Str. Cailor nr. 4", "Bucuresti", listaAlfa);
//		Banca b2 = new Banca ("Banca Beta", "Str. Vacilor nr. 66", "Iasi", listaBeta);
//		Banca b3 = new Banca ("Banca Teta", "Str. Gainilor nr. 5", "Vaslui", listaTeta);
		
//		List<Banca> listaBanci = new ArrayList<Banca>();
//		listaBanci.add(b);
//		listaBanci.add(b2);
//		listaBanci.add(b3);
		
		
//		if (s.isValid() == true) {
//			for(Banca banca:listaBanci) {
//				for(Credit credit:banca.getListaCredite()) {
//					if (s.getTipCredit().equals(credit.getTipCredit())) {
//						if (s.getScor() >= credit.getScor() &&
//								s.getValoareCredit() <= credit.getValoareMax() &&
//								s.getValoareCredit() >= credit.getValoareMin() &&
//								s.getPerioadaCredit() <= credit.getPerioadaMax() &&
//								s.getPerioadaCredit() >= credit.getPerioadaMin() &&
//								s.getMonedaCredit().equals(credit.getMonedaCredit())) {
//							System.out.println("Denumire banca: "+banca.getDenumire()+" "+ " Adresa: "+banca.getAdresa()+" "+" Localitate: "+banca.getLocalitate()+" "+" DAE: "+credit.getDAE());
//						}
//					}
//				}
//			}
//		}
	}
}
