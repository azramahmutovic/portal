package portal.dao;

import java.util.List;

import portal.pojo.Korisnik;

public class Test {

		public static void main(String[] args) throws Exception{ 
			
			KorisnikDAO dao = new KorisnikDAO();
			
			Korisnik k = dao.dajKorisnikaPoEmailu("azra");
			System.out.println(" PASSWORD: " + k.getPassword());
			
			List<Korisnik> korisnici = dao.dajKorisnike();
			
			for(int i=0; i<korisnici.size(); i++){
				System.out.print(" IME: " + korisnici.get(i).getNaziv());
				System.out.print(" EMAIL: " + korisnici.get(i).getEmail());
				System.out.println(" PASSWORD: " + korisnici.get(i).getPassword());
				
			}
			
			
		}
			
}
