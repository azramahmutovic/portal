package portal.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.RegisterModel;

@SuppressWarnings("serial")
public class FinishRegistration extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		String[] kategorije = request.getParameterValues("category");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
		
		Konekcija db = (Konekcija) getServletContext().getAttribute("db");
		RegisterModel register = new RegisterModel();
		register.dodajKategorije(db, email, kategorije);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}
}
