package portal.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class KorisnikDAO {
	
	Konekcija db = new Konekcija();
	private ResultSet resultSet = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public List<Korisnik> dajKorisnike(){
    	
    	List<Korisnik> korisnici = new ArrayList<Korisnik>();
    	try {
    		
    		db.open();
    		statement = db.getStatement(db.getConnection());
    		resultSet = statement
    		          .executeQuery("select * from korisnik");
    		
    		
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
    
	public Korisnik dajKorisnikaPoEmailu(String email){
		
		Korisnik korisnik = new Korisnik();
		
		try {
			
    		db.open();
			preparedStatement = db.prepareStatement(db.getConnection(), "select * from korisnik where email=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				korisnik.setId(resultSet.getInt("id"));
				korisnik.setEmail(resultSet.getString("email"));
				korisnik.setPassword(resultSet.getString("password"));
			}
			
    		db.closeConnection();	
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		}
		
		 return korisnik;
	}
}
