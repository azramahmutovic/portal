package portal.pojo;

public class Korisnik {
	
	private Integer id;
    private String naziv;
	private String email;
	private String password;


	public Korisnik() {
		
	}
	
	public Korisnik(String n, String e, String p){
		naziv = n;
		email = e;
		password = p;
	}
	

	public Integer getId() {
		return id;
	}
        
        public void setId(Integer id) {
		this.id = id;
	}
        
        public String getNaziv() {
		return naziv;
	}
        
        public void setNaziv(String naziv) {
		this.naziv=naziv;
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
	      
}
