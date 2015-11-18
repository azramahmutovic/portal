<%-- 
    Document   : podaciReg1
    Created on : Nov 17, 2015, 11:15:55 PM
    Author     : nurif
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ page import="portal.pojo.Korisnik" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                  
            String naziv=request.getParameter("username");
            String email=request.getParameter("email");
            String pass=request.getParameter("password");
            String pass2=request.getParameter("password2");
            
            Korisnik korisnik = new Korisnik();
            
            korisnik.setNaziv(naziv);
            korisnik.setEmail(email);
            korisnik.setPassword(pass);
            
            korisnik.dodajKorisnika();
            
         %>   
            
        
    </body>
</html>
