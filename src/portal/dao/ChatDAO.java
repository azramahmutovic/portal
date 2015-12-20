package portal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;
import portal.pojo.Poruka;

public class ChatDAO {
	
	private Konekcija db;
	
	public ChatDAO(){
		
		db = new Konekcija();
	}
	
	public List<Integer> dajPrijatelje(Integer korisnik_id){
    	
    	List<Integer> prijatelji = new ArrayList<Integer>();
    	try {
    		
    		db.open();
    		PreparedStatement ps = db.prepareStatement("select DISTINCT(rec_id), created from chat where send_id=? ORDER BY created");
			ps.setInt(1, korisnik_id);
			ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()){
	    		prijatelji.add(rs.getInt("rec_id"));
    		}
    		
    		PreparedStatement ps2 = db.prepareStatement("select DISTINCT(send_id), created from chat where rec_id=? ORDER BY created");
			ps2.setInt(1, korisnik_id);
			ResultSet rs2 = ps2.executeQuery();
    		
    		while(rs2.next()){
    			Integer prijatelj_id = rs2.getInt("send_id");
    			if(!prijatelji.contains(prijatelj_id))
    				prijatelji.add(rs.getInt(0));
    		}
    		
    		db.closeConnection();	
    		
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	return prijatelji;
    }
	
	public List<Poruka> dajPoruke(Integer korisnik1_id, Integer korisnik2_id){
    	
    	List<Poruka> poruke = new ArrayList<Poruka>();
    	try {
    		
    		db.open();
    		PreparedStatement ps = db.prepareStatement("select * from chat where (send_id=? || rec_id=?) AND (send_id=? || rec_id=?)  ORDER BY created");
			ps.setInt(1, korisnik1_id);
			ps.setInt(2, korisnik1_id);
			ps.setInt(3, korisnik2_id);
			ps.setInt(4, korisnik2_id);
			ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()){
    			Poruka poruka = new Poruka();
        		
        		poruka.setId(rs.getInt("id"));
        		poruka.setSadrzaj(rs.getString("message"));
        		poruka.setDatum(rs.getTimestamp("created"));
        		KorisnikDAO dao = new KorisnikDAO();
        		Korisnik k = dao.dajKorisnikaPoID(rs.getInt("send_id"));
        		poruka.setSender(k.getNaziv());
        		poruke.add(poruka);
    		}
    		
    		db.closeConnection();	
    		
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	
    	return poruke;
    }
}
