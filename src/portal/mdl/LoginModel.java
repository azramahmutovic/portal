package portal.mdl;

import java.util.List;

import portal.dao.KategorijaDAO;
import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class LoginModel {
	
	public boolean check(String email, String password){
		
		KorisnikDAO dao = new KorisnikDAO();
		Korisnik k = dao.dajKorisnikaPoEmailu(email);
		if(!k.getEmail().equals("") && !k.getPassword().equals("") && k.getEmail().equals(email) && k.getPassword().equals(password))
			return true;
		else
			return false;
			
	}
	
	public Integer dajKorisnikID(String email){
		
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(email);
		 return k.getId();
	}
	
	public List<String> dajKategorije(Integer korisnik_id){
		
		KategorijaDAO dao = new KategorijaDAO();
		return dao.dajKategorije(korisnik_id);
		
	}
}
