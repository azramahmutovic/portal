package portal.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.RegisterModel;
import portal.pojo.Korisnik;

@SuppressWarnings("serial")
public class RegisterCategories extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		
		String ime = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Korisnik korisnik = new Korisnik(ime, email, password);
		
		RegisterModel register = new RegisterModel();
		register.dodajKorisnika(korisnik);
		
		HttpSession session = request.getSession();
		synchronized(session) {
			Integer userID = register.dajKorisnikID(email);
			session.setAttribute("userID", userID);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("kategorije.jsp");
		view.forward(request, response);
	}
}
