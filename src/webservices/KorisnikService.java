package webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import portal.dao.KorisnikDAO;
import portal.konekcija.Konekcija;
import portal.pojo.Korisnik;

@Path("/korisnik")
public class KorisnikService {
  // This method is called if XMLis request
	

  @GET
  @Path("{email}/{password}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Korisnik getKorisnikbyEmailPassword(@PathParam("email") String email, @PathParam("password") String password) {
	   System.out.println(email);
	   System.out.println(password);
        KorisnikDAO dao = new KorisnikDAO();
	    Korisnik k = dao.dajKorisnikaPoEmailu(email);
		if(!k.getEmail().equals("") && !k.getPassword().equals("") && k.getEmail().equals(email) && k.getPassword().equals(password))
			return k;
		else
			return null;
  
  }
  
  @GET
  @Path("{email}")
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Korisnik getKorisnikbyEmail(@PathParam("email") String email) {
	  
	  KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(email);
     return k;
  
  }
  
  @PUT
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public void dodajKorisnika(JAXBElement<Korisnik> korisnik){
      KorisnikDAO dao=new KorisnikDAO();
      Korisnik k=korisnik.getValue();
      dao.dodajKorisnika(k);   
}
  
/*  @GET
  @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("")
	public Integer dajKorisnikID(Konekcija db, String email){
		
		 KorisnikDAO dao = new KorisnikDAO();
		 Korisnik k = dao.dajKorisnikaPoEmailu(db, email);
		 return k.getId();
	}
	 */
 
  
  

  
}

