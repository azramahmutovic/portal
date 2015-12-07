package portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import portal.konekcija.Konekcija;

public class KategorijaDAO {
	
    public void dodajKategorije(Konekcija db, Integer korisnik_id, String[] kategorije){
        String sql="INSERT INTO odabrana_kategorija(korisnik_id,kategorija_id) VALUES(?, ?)";
        
        try{
            
            db.open();
            	
            PreparedStatement ps = db.prepareStatement(sql);
            ps.setInt(1, korisnik_id);
     
           for(String kategorija : kategorije){
        	   String upit = "SELECT * FROM kategorija WHERE naziv=?";
        	   PreparedStatement statement = db.prepareStatement(upit);
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
    
    public List<String> dajKategorije(Konekcija db, Integer korisnik_id){
    	
    	List<String> kategorije = new ArrayList<String>();
    	try {
    		
    		db.open();
    		PreparedStatement ps = db.prepareStatement("select * from odabrana_kategorija where korisnik_id=?");
			ps.setInt(1, korisnik_id);
			ResultSet resultSet = ps.executeQuery();
    		
    		while(resultSet.next()){
    			
	    		Integer kategorija_id = resultSet.getInt("kategorija_id");
	    		System.out.println(kategorija_id);
	    		PreparedStatement ps2 = db.prepareStatement("SELECT * FROM kategorija where id=?");
	    		ps2.setInt(1, kategorija_id);
	    		ResultSet rs2 = ps2.executeQuery();
	    		
	    		if(rs2.next()){
	    			kategorije.add(rs2.getString("naziv"));
	    		}
    		
    		}
    		
    		db.closeConnection();	
    		
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	return kategorije;
    }
}
