package com.sample.tests;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.sample.*;

public class TestJPA {

	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("1st");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

//---------------------------------------------------------CREATE (Bank)-------------------------------------------------------
//		Banca b1 = new Banca();
//		b1.setDenumire("Banca Alfa");
//		b1.setAdresa("Str. Vacilor nebune nr. 22");
//		b1.setLocalitate("Iasi");
//		em.persist(b1);
//		em.getTransaction().commit();
//		System.out.println("Succes!\nAm adaugat banca: "+b1.getDenumire());

		
//---------------------------------------------------------Read (all banks)-------------------------------------------------------
//		List<Banca> listaBanci = em.createQuery("SELECT b FROM Banca b").getResultList();
//		System.out.println("-------------------------------\nBancile inregistrate sunt:");
//		for(Banca banca:listaBanci) {
//			System.out.println(banca.getDenumire());
//		}
	
//-------------------------------------------------------- UPDATE (Banca) ---------------------------------------------------------
//		Banca b1 = em.find(Banca.class, 51);
//		String numeInitial = b1.getDenumire();
//		b1.setDenumire("Banca redenumita");
//		em.merge(b1);
//		em.getTransaction().commit();
//		System.out.println("Succes!\nDenumirea bancii s-a modificat: \n"+numeInitial+" -> "+b1.getDenumire());
		
//-------------------------------------------------------- DELETE (Banca) ----------------------------------------------------------
//		try {
//			Banca b1 = em.find(Banca.class, 1);
//			em.remove(b1);
//			em.getTransaction().commit();
//			System.out.println("Succes!\nAm eliminat banca: "+b1.getDenumire());	
//		}
//		catch(IllegalArgumentException ex) {
//			System.out.println("Nu s-a gasit banca specificata!\nError:\n"+ex);
//		}


//---------------------------------------------------------CREATE (Credit)-------------------------------------------------------
//		Credit c1 = new Credit();
//		c1.setTipCredit(TipCredit.AUTO);
//		c1.setDenumireCredit("Creditul Auto: banca alfa");
//		c1.setDAE(11.4F);
//		c1.setValoareMin(320000);
//		c1.setValoareMax(700000);
//		c1.setPerioadaMin(12);
//		c1.setPerioadaMax(60);
//		c1.setMonedaCredit(MonedaCredit.RON);
//		c1.setScor(45);
//		System.out.println("Am ajuns aici");
//		// Trebuie sa cautam banca pentru a-i asigna acest credit
//		// pp ca retinem din cbo denumirea bancii selectate
//		String numeBanca = "Banca Alfa";
//		List<Banca> denumireBanca = em.createQuery("SELECT b FROM Banca b WHERE b.denumire= :denBanca")
//				.setParameter("denBanca", numeBanca)
//				.getResultList();
//
//		// Asignam banca rezultata in setter-ul din Credit
//		Banca b = denumireBanca.get(0);
//		b.addCredit(c1);
//		em.persist(c1);
//		em.getTransaction().commit();
//		System.out.println("Am adaugat creditul: "+c1.getDenumireCredit()+" aferent bancii: "+b.getDenumire());
//		for(Credit credit:b.getListaCredite()) {
//			System.out.println("Creditele bancii "+b.getDenumire() +"sunt: \n"+credit.getDenumireCredit());
//		}
	}
}
