<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
    <c:forEach var="poruka" items="${poruke}" >
        <div class="recenzija">
	      <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
	        <img src="img/space.jpg" alt="">
	        <p>${poruka.sender}</p>
	      </div>
	      <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
	        <div class="bubble">
	          <small>${poruka.datum}</small>
	          <h5>${poruka.sadrzaj}</h5>
	        </div>
	      </div>
	    </div>
		</c:forEach>

     <section id="ocjena">
        <div class="ocjena-forma">
          <form role="form" method="post">
           <div class="form-group">
            <input type="hidden" name="friend" value= <c:out value="${friend}"/> >
            <textarea class="form-control" rows="5" id="newMessage" name="newMessage" placeholder="Type new message"></textarea>
            <button type="submit" class="btn btn-default" onclick="return sendMessage();">Send</button>
          </div>
          </form>
        </div>
      </section>