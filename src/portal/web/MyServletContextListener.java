package portal.web;

import javax.servlet.ServletContextListener;

import portal.konekcija.Konekcija;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class MyServletContextListener implements ServletContextListener  {

	 	public void contextInitialized(ServletContextEvent event) {
		 
	    	ServletContext sc = event.getServletContext();
	 
	    	String url = sc.getInitParameter("url");
	    	String user_name = sc.getInitParameter("user_name");
	    	String password = sc.getInitParameter("password");
	    	String database = sc.getInitParameter("database");
	    	Konekcija db = new Konekcija(url + database, user_name, password);
	    	db.open();
	    	sc.setAttribute("db", db);
	 
	    }
	 
	    public void contextDestroyed(ServletContextEvent arg0) {
	        // TODO Auto-generated method stub
	    }
	 
}
