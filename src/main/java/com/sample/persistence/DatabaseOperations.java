package com.sample.persistence;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sample.Banca;
import com.sample.Credit;
import com.sample.MonedaCredit;
import com.sample.TipCredit;


@SuppressWarnings("restriction")
public class DatabaseOperations {
	private static final String PERSISTENCE_UNIT_NAME = "1st";
	private static EntityManager em = Persistence.createEntityManagerFactory("1st")
										.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();
	
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- CREATE BANK ----------------------------------------
	// ------------------------------------------------------------------------------------------
	public static void addBanca(Banca banca) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		em.persist(banca);
		transaction.commit();
		System.out.println("Succes!\nAm adaugat banca: "+banca.getDenumire());
	}
		
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- UPDATE BANK ----------------------------------------
	// ------------------------------------------------------------------------------------------
	public static void updateBanca(Integer id, String denumire, String adresa, String localitate) {
		if(!transaction.isActive()) {
			transaction.begin();
		}
		Banca b = em.find(Banca.class, id);
		b.setDenumire(denumire);
		b.setAdresa(adresa);
		b.setLocalitate(localitate);
		em.merge(b);
		transaction.commit();
	}
	
	// ------------------------------------------------------------------------------------------
	// ----------------------------------FETCH @params for UPDATE -------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public static List getParameters() {
		List<String> parameterList = new ArrayList<String>();
		String param_id =  FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("selectedIdUpd");
		parameterList.add(param_id);
		String param_denumire = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("selectedDenUpd");
		parameterList.add(param_denumire);
		String param_adresa = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("selectedAdrUpd");
		parameterList.add(param_adresa);
		String param_localitate = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("selectedLocUpd");
		parameterList.add(param_localitate);
		
		if (parameterList != null && parameterList.size()>0) {
			return parameterList;
		}
		return null;
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- REMOVE BANK ----------------------------------------
	// ------------------------------------------------------------------------------------------
	public static void removeBanca(Banca banca) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		try {
		String param_id = FacesContext.getCurrentInstance()
						.getExternalContext()
						.getRequestParameterMap()
						.get("selectedId");
		int id_ = Integer.parseInt(param_id);
		banca = em.find(Banca.class, id_);
		em.remove(banca);
		em.getTransaction().commit();
		System.out.println("Succes!\nAm eliminat banca: "+banca.getDenumire());	
	}
	catch(IllegalArgumentException ex) {
		System.out.println("Nu s-a gasit banca specificata!\nError:\n"+ex);
	}
		
	}

	
	// ------------------------------------------------------------------------------------------
	// -------------------------------------GET CREDITS FOR BANK @X------------------------------
	// ------------------------------------------------------------------------------------------
	public static List<Credit> lista(Integer id_){
		@SuppressWarnings("unchecked")
		List<Credit> listaCredite = em.createNativeQuery("SELECT * FROM credit WHERE banca_idbanca=?id", Credit.class)
				.setParameter("id", id_)
				.getResultList();
			if (listaCredite != null && listaCredite.size()>0) {
					return listaCredite;
				}
				return null;
			}

	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- GET ALL BANKS --------------------------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public static List<Banca> getAllBanks() {
		if(!transaction.isActive()) {
			transaction.begin();
		}
		List<Banca> listaBanci = em.createQuery("SELECT b FROM Banca b").getResultList();
		if (listaBanci != null && listaBanci.size()>0) {
			return listaBanci;
		}
		return null;
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- GET BANKS NAMES (for CBO) --------------------------
	// ------------------------------------------------------------------------------------------
	public static List<Banca> getDenumireBanci(){
		List<Banca> listaDenumireBanci = em.createQuery("SELECT b.denumire FROM Banca b").getResultList();
		if (listaDenumireBanci != null && listaDenumireBanci.size()>0) {
			return listaDenumireBanci;
		}
		return null;
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- CREATE A NEW CREDIT---------------------------------
	// ------------------------------------------------------------------------------------------
	public static void addCredit(String tip_, String denumire_, Float dae_, 
			Integer vmin_, Integer vmax_, Integer pmin_, Integer pmax_,
									String moneda_, Integer scor_, Banca b_){
		if(!transaction.isActive()) {
			transaction.begin();
		}
		Credit credit = new Credit();
		credit.setTipCredit(TipCredit.valueOf(tip_));
		credit.setDenumireCredit(denumire_);
		credit.setDAE(dae_);
		credit.setValoareMin(vmin_);
		credit.setValoareMax(vmax_);
		credit.setPerioadaMin(pmin_);
		credit.setPerioadaMax(pmax_);
		credit.setMonedaCredit(MonedaCredit.valueOf(moneda_));
		credit.setScor(scor_);
		
		b_.addCredit(credit);
		em.persist(credit);
		transaction.commit();
		System.out.println("Am adaugat creditul: "+credit.getDenumireCredit()+" aferent bancii: "+b_.getDenumire());
	}
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------- REMOVE A SPECIFIED CREDIT---------------------------
	// ------------------------------------------------------------------------------------------
	public static void removeCredit(Credit credit) {
		if(!transaction.isActive()) {
			transaction.begin();
		}		
		try {
			em.remove(credit);
			transaction.commit();
		}
		catch(Exception ex) {
			System.out.println("Eroare");
		}
	}
	
	
	// Method to retrieve the bank Object needed to assign 
	// the specified credit to
	// ------------------------------------------------------------------------------------------
	// ---------------------------- GET THE BANK FOR WHICH THE CREDIT IS ADDED-------------------
	// ------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public static List<Banca> getBancaObject(String name) {
		List<Banca> objectBanca = em.createQuery("SELECT b FROM Banca b WHERE b.denumire= :denBanca")
				.setParameter("denBanca", name)
				.getResultList();
		if (objectBanca != null && objectBanca.size()>0) {
			return objectBanca;
		}
		return null;
	}	
}
