<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="portal.pojo.Korisnik" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        Korisnik korisnik = new Korisnik();
       
        if(korisnik.checkLogin(email, password)){
            session.setAttribute("email",email);
            response.sendRedirect("home.jsp");
        }
        else{
        	response.sendRedirect("error.jsp");
        }
            
        %>
</body>
</html>