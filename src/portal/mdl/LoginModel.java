package portal.mdl;

import portal.dao.KorisnikDAO;
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
	
	
}
