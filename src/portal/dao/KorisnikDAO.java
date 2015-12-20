package portal.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException; 
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

public class KorisnikDAO {
	
	private ResultSet resultSet = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private PreparedStatement ubaciKorisnika=null;
    private PreparedStatement ps=null; 
    
	private Konekcija db;
	
	public KorisnikDAO(){
		
		db = new Konekcija();
	}
	
    public List<Korisnik> dajKorisnike(){
    	
    	List<Korisnik> korisnici = new ArrayList<Korisnik>();
    	try {
    		
    		db.open();
    		statement = db.getStatement();
    		resultSet = statement
    		          .executeQuery("select * from korisnik");
    		
    		
    		while(resultSet.next()){
    		Korisnik korisnik = new Korisnik();
    		
    		korisnik.setId(resultSet.getInt("id"));
    		korisnik.setNaziv(resultSet.getString("naziv"));
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
    
    public Korisnik dajKorisnikaPoID(Integer korisnik_id){
		
		Korisnik korisnik = new Korisnik();
		
		try {
			
    		db.open();
			preparedStatement = db.prepareStatement("select * from korisnik where id=?");
			preparedStatement.setInt(1, korisnik_id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				korisnik.setId(resultSet.getInt("id"));
				korisnik.setNaziv(resultSet.getString("naziv"));
				korisnik.setEmail(resultSet.getString("email"));
				korisnik.setPassword(resultSet.getString("password"));
			}
			
    		db.closeConnection();	
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		}
		
		 return korisnik;
	}
    
	public Korisnik dajKorisnikaPoEmailu(String email){
		
		Korisnik korisnik = new Korisnik();
		
		try {
			
    		db.open();
			preparedStatement = db.prepareStatement("select * from korisnik where email=?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				korisnik.setId(resultSet.getInt("id"));
				korisnik.setNaziv(resultSet.getString("naziv"));
				korisnik.setEmail(resultSet.getString("email"));
				korisnik.setPassword(resultSet.getString("password"));
			}
			else{
				korisnik.setEmail("");
				korisnik.setPassword("");
			}
    		db.closeConnection();	
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		}
		
		 return korisnik;
	}
        
         public void dodajKorisnika(Korisnik k){
            String sql="INSERT INTO korisnik(naziv,email,password) VALUES(?, ?, ?)";
            
            try{
                
                db.open();
                
                   ubaciKorisnika=db.prepareStatement(sql);
                   
                   ubaciKorisnika.setString(1, k.getNaziv());
                   ubaciKorisnika.setString(2, k.getEmail());
                   ubaciKorisnika.setString(3, k.getPassword());
                   
                   ubaciKorisnika.executeUpdate();
                           
                db.closeConnection();	
            
                } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
                 
        public void dodajPost(Integer korisnik_id, String kategorija, String tekst, String imgPath){
            String sql="INSERT INTO post(korisnik_id, kategorija_id, tekst, img) VALUES(?, ?, ?, ?)";
            
            try{
                
                db.open();
                	
                ps = db.prepareStatement(sql);
                ps.setInt(1, korisnik_id);
         
            	   String upit = "SELECT * FROM kategorija WHERE naziv=?";
            	   PreparedStatement statement = db.prepareStatement(upit);
            	   statement.setString(1, kategorija);
            	   ResultSet rs = statement.executeQuery();
            	   if(rs.next()){
            		   Integer kategorija_id = rs.getInt("id");
            		   ps.setInt(2, kategorija_id);
            	   }
            	   
               ps.setString(3, tekst);   
               ps.setString(4, imgPath);
               ps.executeUpdate();
               
               db.closeConnection();	
            
                } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
