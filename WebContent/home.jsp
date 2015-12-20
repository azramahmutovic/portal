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
          <button type="button" class="btn btn-info" onclick="return loadPosts('novi-post.jsp');">Publish Post</button>
          <button type="button" class="btn btn-default">Profile</button>
          <a href="inbox"><button type="button" class="btn btn-default">Messages</button></a>
        </div>
        
      </div>

    </div>
  </header>
</section>
<section id="homepage">
  <div class="container">
    <div class="col-md-3">
      <section id="info">
      <h3>categories</h3>
      <div class="categories">
        <ul>
        <c:forEach var="kategorija" items="${kategorije}" >
			<li><a href="" onclick="return loadPosts('kategorija-postovi.jsp');">${kategorija}</a></li>
		</c:forEach>
        </ul>     
      </div>   
    </section>
    </div>
    <div class="col-md-9">

 	<section id="posts">
	<div ID="postWrapper">
    <!-- latest posts -->

      <h2 class="line-title"><span>latest posts</span></h2>
		
       <div id="latestPostSlide" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#latestPostSlide" data-slide-to="0" class="active"></li>
          <li data-target="#latestPostSlide" data-slide-to="1"></li>
          <li data-target="#latestPostSlide" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="img/latest-post.jpg" alt="...">
            <h1>SAMPLE POST WITH IMAGE ALIGNED RIGHT</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dui purus, imperdiet quis luctus ut, commodo porttitor mauris. Etiam non pellentesque massa. Integer hendrerit odio ut molestie dictum. Nulla mollis suscipit tellus non semper. Cras vitae nunc dictum, malesuada turpis eu, rhoncus nisl. Nullam congue facilisis orci, sit amet consequat dui venenatis sed. Phasellus rhoncus libero vel lectus cursus, sed tempor leo cursus. Donec condimentum metus magna, vel porta urna laoreet a. Morbi posuere et dolor id auctor. Integer condimentum nunc nec sagittis fringilla. In non pretium nunc. </p>
            <div class="read-more">
              <small>SEP 30, 2015</small>
              <a href="">read more</a>
            </div>
          </div>
          <div class="item">
            <img src="img/latest-post.jpg" alt="...">
            <h1>SAMPLE POST WITH IMAGE ALIGNED RIGHT</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dui purus, imperdiet quis luctus ut, commodo porttitor mauris. Etiam non pellentesque massa. Integer hendrerit odio ut molestie dictum. Nulla mollis suscipit tellus non semper. Cras vitae nunc dictum, malesuada turpis eu, rhoncus nisl. Nullam congue facilisis orci, sit amet consequat dui venenatis sed. Phasellus rhoncus libero vel lectus cursus, sed tempor leo cursus. Donec condimentum metus magna, vel porta urna laoreet a. Morbi posuere et dolor id auctor. Integer condimentum nunc nec sagittis fringilla. In non pretium nunc. </p>
            <div class="read-more">
              <small>SEP 30, 2015</small>
              <a href="">read more</a>
            </div>
          </div>
          <div class="item">
            <img src="img/latest-post.jpg" alt="...">
            <h1>SAMPLE POST WITH IMAGE ALIGNED RIGHT</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dui purus, imperdiet quis luctus ut, commodo porttitor mauris. Etiam non pellentesque massa. Integer hendrerit odio ut molestie dictum. Nulla mollis suscipit tellus non semper. Cras vitae nunc dictum, malesuada turpis eu, rhoncus nisl. Nullam congue facilisis orci, sit amet consequat dui venenatis sed. Phasellus rhoncus libero vel lectus cursus, sed tempor leo cursus. Donec condimentum metus magna, vel porta urna laoreet a. Morbi posuere et dolor id auctor. Integer condimentum nunc nec sagittis fringilla. In non pretium nunc.  </p>
            <div class="read-more">
              <small>SEP 30, 2015</small>
              <a href="">read more</a>
            </div>
          </div>
        </div>
      </div>

      <h2 class="line-title"><span>popular posts</span></h2>
       <div class="row">
              <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                <div class="post">
                  <div class="picture">
                    <img src="img/popular1.jpg" class="img-responsive" alt="...">
                  </div>
                    <h1>SAMPLE POST WITH IMAGE ALIGNED RIGHT</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dui purus, imperdiet quis luctus ut, commodo porttitor mauris. Etiam non pellentesque massa. Integer hendrerit odio ut molestie dictum. Nulla mollis suscipit tellus non semper. Cras vitae nunc dictum, malesuada turpis eu, rhoncus nisl. Nullam congue facilisis orci, sit amet consequat dui venenatis sed. Phasellus rhoncus libero vel lectus cursus, sed tempor leo cursus. Donec condimentum metus magna, vel porta urna laoreet a. Morbi posuere et dolor id auctor. Integer condimentum nunc nec sagittis fringilla. In non pretium nunc. </p>
                    <div class="read-more">
                      <small>SEP 30, 2015</small>
                      <a href="">read more</a>
                    </div>
                </div>
              </div>

              <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                <div class="post">
                    <div class="picture">
                    <img src="img/popular2.jpg" class="img-responsive" alt="...">
                  </div>
                    <h1>SAMPLE POST WITH IMAGE ALIGNED RIGHT</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin dui purus, imperdiet quis luctus ut, commodo porttitor mauris. Etiam non pellentesque massa. Integer hendrerit odio ut molestie dictum. Nulla mollis suscipit tellus non semper. Cras vitae nunc dictum, malesuada turpis eu, rhoncus nisl. Nullam congue facilisis orci, sit amet consequat dui venenatis sed. Phasellus rhoncus libero vel lectus cursus, sed tempor leo cursus. Donec condimentum metus magna, vel porta urna laoreet a. Morbi posuere et dolor id auctor. Integer condimentum nunc nec sagittis fringilla. In non pretium nunc. </p>
                  <div class="read-more">
                    <small>SEP 30, 2015</small>
                    <a href="">read more</a>
                  </div>
                </div>
              </div>
        </div>
     </div>
    </section>
    
    </div>



  </div>
</section>
	<script src="js/skripta.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>