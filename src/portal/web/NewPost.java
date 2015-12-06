package portal.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.pojo.RegisterModel;


@SuppressWarnings("serial")
public class NewPost extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		String kategorija = request.getParameter("kategorija");
		String tekst = request.getParameter("tekst");
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("user");
	
		RegisterModel register = new RegisterModel();
		register.dodajPost(email, kategorija, tekst);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}
}
