package webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import portal.dao.KategorijaDAO;

import portal.konekcija.Konekcija;

@Path("/kategorije")
public class KategorijeService {

@PUT
@Path("{id}/{kategorije}")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public void dodajKategorije(Konekcija db, @PathParam("id") Integer korisnik_id, @PathParam("kategorije") String[] kategorije){
		  KategorijaDAO katDAO = new KategorijaDAO();
		   katDAO.dodajKategorije(korisnik_id, kategorije);
	 }
	 
	
	 
}

	
	
	
	

