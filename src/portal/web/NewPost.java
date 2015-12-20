package portal.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import portal.konekcija.Konekcija;
import portal.mdl.LoginModel;
import portal.mdl.PostModel;

@MultipartConfig
@SuppressWarnings("serial")
public class NewPost extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {
		
		String kategorija = request.getParameter("kategorija");
		String tekst = request.getParameter("tekst");
		
		//slika
		Part filePart = request.getPart("file"); 
	    
		HttpSession session = request.getSession();
		Integer userID = (Integer) session.getAttribute("userID");
		
		PostModel post = new PostModel();
		String imgPath = post.spasiSliku(filePart, userID);
		post.dodajPost(userID, kategorija, tekst, imgPath);
		
		//kategorije na pocetnoj
		LoginModel login = new LoginModel();
		List<String> kategorije = login.dajKategorije(userID);
		request.setAttribute("kategorije", kategorije);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}
}
