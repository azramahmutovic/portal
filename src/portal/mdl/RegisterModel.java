package portal.mdl;

import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class RegisterModel {
	
	 public void dodajKorisnika(Konekcija db, Korisnik k){
	      KorisnikDAO dao=new KorisnikDAO();
	      dao.dodajKorisnika(db, k);   
	    }
	 
	 public void dodajKategorije(Konekcija db, String email, String[] kategorije){
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(db, email);
		 Integer id = k.getId();
		 dao.dodajKategorije(db, id, kategorije);
	 }
	 
	 public void dajKategorije(String email){
		 
	 }
	 
	 public void dodajPost(Konekcija db, String email, String kategorija, String tekst){
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(db, email);
		 Integer id = k.getId();
		 dao.dodajPost(db, id, kategorija, tekst);
	 }
}
