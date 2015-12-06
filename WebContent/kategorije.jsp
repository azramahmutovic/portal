<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<div class="background"></div>
    <section id="kategorije">
      <header>
        <h1>Categories</h1>
        <p>Select all the topics you're interested in</p>
      </header>
      <form action="finish-registration" method="post">
      
      <div class="row">
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            
            <img src="img/Technology.jpe" alt="...">
          	<div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Tech" autocomplete="off"> Tech
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            
            <img src="img/Science.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Science" autocomplete="off"> Science
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/Books.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Books" autocomplete="off"> Books
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/IT.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="IT" autocomplete="off"> IT
            </label>
            </div>
          </a>
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/Sport.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Sport" autocomplete="off"> Sport
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/Music.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Music" autocomplete="off"> Music
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/Movies.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Movies" autocomplete="off"> Movies
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/Food.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Food" autocomplete="off"> Food
            </label>
            </div>
          </a>
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/Fashion.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Fashion" autocomplete="off"> Fashion
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/umjetnost.jpg" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Art" autocomplete="off"> Art
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/space.jpg" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="Space" autocomplete="off"> Space
            </label>
            </div>
          </a>
        </div>
        <div class="col-md-3">
          <a href="#" class="thumbnail">
            <img src="img/History.jpe" alt="...">
            <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-primary">
                 <input type="checkbox" name="category" value="History" autocomplete="off"> History
            </label>
            </div>
          </a>
        </div>
      </div>
      <button type="submit" class="btn btn-default">Register</button>
      </form>
    </section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>