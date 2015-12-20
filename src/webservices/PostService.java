package webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import portal.dao.KorisnikDAO;


@Path("/post")
public class PostService {
	
	 @PUT
	 @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 @Path("{id}/{kategorija}/{tekst}/{slika}")
		 public void dodajPost(@PathParam("id") Integer korisnik_id,@PathParam("kategorija") String kategorija,@PathParam("tekst") String tekst,@PathParam("slika") String slika){
		 KorisnikDAO dao = new KorisnikDAO();
		 dao.dodajPost(korisnik_id, kategorija, tekst, slika);
	 }

}
