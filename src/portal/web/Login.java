package portal.web;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jackson.JacksonFeature;

import org.glassfish.jersey.client.ClientConfig;


import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.LoginModel;

import java.io.*;
import java.util.List;

@SuppressWarnings("serial")
public class Login extends HttpServlet{
	
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:8080/portal").build();
	  }
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
			
			ClientConfig config = new ClientConfig().register(new JacksonFeature());
		    Client client = ClientBuilder.newClient(config);
		    WebTarget service = client.target(getBaseURI());
		   
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			String s = service.path("rest").path("korisnik").path("email").path("password").request().accept(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println(s);
			
			LoginModel login = new LoginModel();
			
			//provjera podataka
			boolean loggedIn = login.check(email,password);
			RequestDispatcher view;
			
			if(loggedIn){
				
				HttpSession session = request.getSession();
				Integer userID;
				synchronized(session) {
					userID = login.dajKorisnikID(email);
					session.setAttribute("userID", userID);
				}
				
				//ucitaj kategorije koje korisnik prati
				List<String> kategorije = login.dajKategorije(userID);
				request.setAttribute("kategorije", kategorije);
				view = request.getRequestDispatcher("home.jsp");
			}
				
			else{
				view = request.getRequestDispatcher("error.jsp");
			}
				
			view.forward(request, response);
				
	}
}
