package portal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.ChatModel;
import portal.pojo.Korisnik;

@SuppressWarnings("serial")
public class Inbox extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userID");
		
		ChatModel chat = new ChatModel();
		List<Korisnik> prijatelji = chat.dajPrijatelje(userID);
		
		request.setAttribute("prijatelji", prijatelji);
		
		RequestDispatcher view = request.getRequestDispatcher("inbox.jsp");
		view.forward(request, response);
	}
}
