package portal.mdl;

import portal.dao.KorisnikDAO;
import portal.pojo.Korisnik;

public class RegisterModel {
	
	 public void dodajKorisnika(Korisnik k){
	      KorisnikDAO dao=new KorisnikDAO();
	      dao.dodajKorisnika(k);   
	    }
	 
	 public void dodajKategorije(String email, String[] kategorije){
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(email);
		 Integer id = k.getId();
		 dao.dodajKategorije(id, kategorije);
	 }
	 
	 public void dodajPost(String email, String kategorija, String tekst){
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(email);
		 Integer id = k.getId();
		 dao.dodajPost(id, kategorija, tekst);
	 }
}
