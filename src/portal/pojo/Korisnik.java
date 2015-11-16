package portal.pojo;

import portal.dao.KorisnikDAO;

public class Korisnik {
	
	private Integer id;
	private String email;
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkLogin(String email, String password){
		
		KorisnikDAO dao = new KorisnikDAO();
		Korisnik k = dao.dajKorisnikaPoEmailu(email);
		if(!k.getEmail().equals("") && !k.getPassword().equals("") && k.getEmail().equals(email) && k.getPassword().equals(password))
			return true;
		else
			return false;
			
	}
}
