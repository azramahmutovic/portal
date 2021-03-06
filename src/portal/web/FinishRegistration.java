package portal.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.mdl.RegisterModel;

@SuppressWarnings("serial")
public class FinishRegistration extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		String[] kategorije = request.getParameterValues("category");
		
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userID");
		
		RegisterModel register = new RegisterModel();
		register.dodajKategorije(userID, kategorije);
		
		request.setAttribute("kategorije", kategorije);
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}
}
