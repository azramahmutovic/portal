package portal.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class KorisnikDAO {
	
	Konekcija db = new Konekcija();
	private ResultSet resultSet = null;
    private Statement statement = null;
    
    public List<Korisnik> dajKorisnike(){
    	
    	List<Korisnik> korisnici = new ArrayList<Korisnik>();
    	try {
    		
    		db.open();
    		db.getConnection();
    		statement = db.getStatement();
    		resultSet = statement
    		          .executeQuery("select * from portal.korisnik");
    		
    		
    		while(resultSet.next()){
    		Korisnik korisnik = new Korisnik();
    		
    		korisnik.setId(resultSet.getInt("id"));
    		korisnik.setEmail(resultSet.getString("email"));
    		korisnik.setPassword(resultSet.getString("password"));
    		korisnici.add(korisnik);
    		}
    		
    		db.closeConnection();	
    		
    		} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return korisnici;
    }
}
