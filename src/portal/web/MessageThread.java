package portal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.ChatModel;
import portal.pojo.Poruka;

@SuppressWarnings("serial")
public class MessageThread extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		Integer friend = Integer.parseInt(request.getParameter("prijateljID").trim());
		
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userID");
		
		if(request.getParameter("poruka") != null){
			System.out.println("ima poruke");
		}
		
		ChatModel chat = new ChatModel();
		List<Poruka> poruke = chat.dajPoruke(userID, friend);
		
		request.setAttribute("poruke", poruke);
		request.setAttribute("friend", friend);
		RequestDispatcher view = request.getRequestDispatcher("messages-box.jsp");
		view.forward(request, response);
	}
}
