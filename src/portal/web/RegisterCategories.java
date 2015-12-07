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
		
		Konekcija db = (Konekcija) getServletContext().getAttribute("db");
		RegisterModel register = new RegisterModel();
		register.dodajKorisnika(db, korisnik);
		
		HttpSession session = request.getSession();
		synchronized(session) {
			session.setAttribute("user", email);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("kategorije.jsp");
		view.forward(request, response);
	}
}
