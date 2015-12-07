package portal.web;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.LoginModel;

import java.io.*;
import java.util.List;

@SuppressWarnings("serial")
public class Login extends HttpServlet{
	
	public void init (ServletConfig config) 
			throws ServletException{
		
           super.init(config);
           
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			LoginModel login = new LoginModel();
			Konekcija db = (Konekcija) getServletContext().getAttribute("db");
			
			//provjera podataka
			boolean loggedIn = login.check(db,email,password);
			
			RequestDispatcher view;
			
			if(loggedIn){
				
				HttpSession session = request.getSession();
				Integer userID;
				synchronized(session) {
					userID = login.dajKorisnikID(db, email);
					session.setAttribute("userID", userID);
				}
				
				//ucitaj kategorije koje korisnik prati
				List<String> kategorije = login.dajKategorije(db, userID);
				request.setAttribute("kategorije", kategorije);
				view = request.getRequestDispatcher("home.jsp");
			}
				
			else{
				view = request.getRequestDispatcher("error.jsp");
			}
				
			view.forward(request, response);
				
	}
}
