package portal.web;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher view = request.getRequestDispatcher("registracija.jsp");
		view.forward(request, response);
	}
}
