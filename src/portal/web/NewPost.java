package portal.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.RegisterModel;


@SuppressWarnings("serial")
public class NewPost extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		String kategorija = request.getParameter("kategorija");
		String tekst = request.getParameter("tekst");
		
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userID");
	
		Konekcija db = (Konekcija) getServletContext().getAttribute("db");
		RegisterModel register = new RegisterModel();
		register.dodajPost(db, userID, kategorija, tekst);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}
}
