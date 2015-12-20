package portal.mdl;

import java.util.ArrayList;
import java.util.List;

import portal.dao.ChatDAO;
import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;
import portal.pojo.Poruka;

public class ChatModel {
	
	public List<Korisnik> dajPrijatelje(Integer korisnik_id){
		
		List<Korisnik> prijatelji = new ArrayList<Korisnik>();
	
		ChatDAO dao = new ChatDAO();
		List<Integer> prijatelji_id = dao.dajPrijatelje(korisnik_id);
		
		KorisnikDAO kdao = new KorisnikDAO();
		for(Integer p_id : prijatelji_id){
			Korisnik k = kdao.dajKorisnikaPoID(p_id);
			prijatelji.add(k);
		}
		
		return prijatelji;
	}
	
	public List<Poruka> dajPoruke(Integer korisnik1_id, Integer korisnik2_id){
		
		ChatDAO dao = new ChatDAO();
		return dao.dajPoruke(korisnik1_id, korisnik2_id);
		
	}
}
