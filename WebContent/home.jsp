<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Portal</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<title>Insert title here</title>
</head>
<body>

<section id="pocetna">
<header>    
  <div class="container">
    <div class="col-md-2">
        <h1>Portal</h1>
      </div>
      <div class="col-md-6">
        <div class="input-group">
      <input type="text" class="form-control" placeholder="Search">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
      </span>
        </div>
      </div>
      <div class="col-md-4">
        <div class="profil-btn">
          <button type="button" class="btn btn-info" onclick="ucitaj('novi-post.jsp')">Publish Post</button>
          <button type="button" class="btn btn-default">Profile</button>
          <button type="button" class="btn btn-default">Messages</button>
        </div>
        
      </div>

    </div>
  </header>
</section>
<div ID="wrapper">
<section id="homepage">
  <div class="container">
    <div class="col-md-3">
      <div class="panel panel-info">
        <!-- Default panel contents -->
        <div class="panel-heading">My categories</div>
        
        <!-- List group -->
        <ul class="list-group">
        <c:forEach var="kategorija" items="${kategorije}" >
			<li class="list-group-item">${kategorija}</li>
		</c:forEach>
        </ul>
      </div>
    </div>
    <div class="col-md-9">
          <div class="panel panel-primary">
          <!-- Default panel contents -->
          <div class="panel-heading">Posts</div>
          <div class="panel-body">
            <p>...</p>
          </div>
    </div>
    </div>

  </div>
</section>
</div>
	<script src="js/skripta.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>