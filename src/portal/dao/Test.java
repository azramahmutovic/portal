package portal.dao;

import java.util.List;

import portal.pojo.Korisnik;

public class Test {

		public static void main(String[] args) throws Exception{ 
			
			KorisnikDAO dao = new KorisnikDAO();
			List<Korisnik> korisnici = dao.dajKorisnike();
			
			for(int i=0; i<korisnici.size(); i++){
				System.out.print(" USERNAME: " + korisnici.get(i).getEmail());
				System.out.println(" PASSWORD: " + korisnici.get(i).getPassword());
			}
			
		}
			
}
