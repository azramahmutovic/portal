package portal.mdl;

import java.util.List;

import portal.dao.KategorijaDAO;
import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class LoginModel {
	
	public boolean check(Konekcija db,String email, String password){
		
		KorisnikDAO dao = new KorisnikDAO();
		Korisnik k = dao.dajKorisnikaPoEmailu(db, email);
		if(!k.getEmail().equals("") && !k.getPassword().equals("") && k.getEmail().equals(email) && k.getPassword().equals(password))
			return true;
		else
			return false;
			
	}
	
	public Integer dajKorisnikID(Konekcija db, String email){
		
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(db, email);
		 return k.getId();
	}
	
	public List<String> dajKategorije(Konekcija db, Integer korisnik_id){
		
		KategorijaDAO dao = new KategorijaDAO();
		return dao.dajKategorije(db, korisnik_id);
		
	}
}
