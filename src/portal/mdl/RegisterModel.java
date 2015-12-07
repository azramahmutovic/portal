package portal.mdl;

import portal.dao.KategorijaDAO;
import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class RegisterModel {
	
	 public void dodajKorisnika(Konekcija db, Korisnik k){
	      KorisnikDAO dao=new KorisnikDAO();
	      dao.dodajKorisnika(db, k);   
	}
	 
	public Integer dajKorisnikID(Konekcija db, String email){
		
			 KorisnikDAO dao = new KorisnikDAO();
			 Korisnik k = dao.dajKorisnikaPoEmailu(db, email);
			 return k.getId();
	}
	 
	 public void dodajKategorije(Konekcija db, Integer korisnik_id, String[] kategorije){
		 
		 KategorijaDAO katDAO = new KategorijaDAO();
		 katDAO.dodajKategorije(db, korisnik_id, kategorije);
	 }
	 
	 public void dajKategorije(Konekcija db, String email){
		 
	 }
	 
	 public void dodajPost(Konekcija db, Integer korisnik_id, String kategorija, String tekst){
		 KorisnikDAO dao = new KorisnikDAO();
		 dao.dodajPost(db, korisnik_id, kategorija, tekst);
	 }
}
