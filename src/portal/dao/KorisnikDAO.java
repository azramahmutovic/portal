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
	
	Konekcija db = new Konekcija();
	private ResultSet resultSet = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private PreparedStatement ubaciKorisnika=null;
    private PreparedStatement ps=null; 
    
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
    
	public Korisnik dajKorisnikaPoEmailu(String email){
		
		Korisnik korisnik = new Korisnik();
		
		try {
			
    		db.open();
			preparedStatement = db.prepareStatement(db.getConnection(), "select * from korisnik where email=?");
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
                
                   ubaciKorisnika=db.prepareStatement(db.getConnection(), sql);
                   
                   ubaciKorisnika.setString(1, k.getNaziv());
                   ubaciKorisnika.setString(2, k.getEmail());
                   ubaciKorisnika.setString(3, k.getPassword());
                   
                   ubaciKorisnika.executeUpdate();
                           
                db.closeConnection();	
            
                } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
         
        public void dodajKategorije(Integer korisnik_id, String[] kategorije){
            String sql="INSERT INTO odabrana_kategorija(korisnik_id,kategorija_id) VALUES(?, ?)";
            
            try{
                
                db.open();
                	
                ps = db.prepareStatement(db.getConnection(), sql);
                ps.setInt(1, korisnik_id);
         
               for(String kategorija : kategorije){
            	   String upit = "SELECT * FROM kategorija WHERE naziv=?";
            	   PreparedStatement statement = db.prepareStatement(db.getConnection(), upit);
            	   statement.setString(1, kategorija);
            	   ResultSet rs = statement.executeQuery();
            	   if(rs.next()){
            		   Integer kategorija_id = rs.getInt("id");
            		   ps.setInt(2, kategorija_id);
            	   }
            	   ps.addBatch();
               }
               
               ps.executeBatch();
               
               db.closeConnection();	
            
                } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        public void dodajPost(Integer korisnik_id, String kategorija, String tekst){
            String sql="INSERT INTO post(korisnik_id, kategorija_id, tekst) VALUES(?, ?, ?)";
            
            try{
                
                db.open();
                	
                ps = db.prepareStatement(db.getConnection(), sql);
                ps.setInt(1, korisnik_id);
         
            	   String upit = "SELECT * FROM kategorija WHERE naziv=?";
            	   PreparedStatement statement = db.prepareStatement(db.getConnection(), upit);
            	   statement.setString(1, kategorija);
            	   ResultSet rs = statement.executeQuery();
            	   if(rs.next()){
            		   Integer kategorija_id = rs.getInt("id");
            		   ps.setInt(2, kategorija_id);
            	   }
            	   
               ps.setString(3, tekst);   
               ps.executeUpdate();
               
               db.closeConnection();	
            
                } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
