package portal.web;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.LoginModel;

import java.io.*;

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
			boolean loggedIn = login.check(db,email,password);
			
			RequestDispatcher view;
			
			if(loggedIn){
				
				HttpSession session = request.getSession();
				synchronized(session) {
					session.setAttribute("user", email);
				}
				view = request.getRequestDispatcher("home.jsp");
			}
				
			else{
				view = request.getRequestDispatcher("error.jsp");
			}
				
			view.forward(request, response);
				
	}
}
