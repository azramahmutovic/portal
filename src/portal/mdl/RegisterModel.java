package portal.mdl;

import portal.dao.KategorijaDAO;
import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class RegisterModel {
	
	 public void dodajKorisnika(Korisnik k){
	      KorisnikDAO dao=new KorisnikDAO();
	      dao.dodajKorisnika(k);   
	}
	 
	public Integer dajKorisnikID(String email){
		
			 KorisnikDAO dao = new KorisnikDAO();
			 Korisnik k = dao.dajKorisnikaPoEmailu(email);
			 return k.getId();
	}
	 
	 public void dodajKategorije(Integer korisnik_id, String[] kategorije){
		 
		 KategorijaDAO katDAO = new KategorijaDAO();
		 katDAO.dodajKategorije(korisnik_id, kategorije);
	 }
	 
	 public void dajKategorije(String email){
		 
	 }
}
