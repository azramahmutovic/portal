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
<script src="js/otvaranjestranice.js"></script>
</head>
<body>
<div class="background"></div>
    <section id="login">
      <header>
        <h1>Portal</h1>
      </header>
         <form class="form-horizontal" role="form" action="loginCheck.jsp" method="post">
          <div class="form-group">
          <label class="control-label col-sm-2" for="user">
            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
          </label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="user" placeholder="Full name">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="email">
            <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
          </label>
          <div class="col-sm-10">
            <input type="email" class="form-control" name="email" placeholder="Email">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="pwd">
             <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
          </label>
          <div class="col-sm-10">
            <input type="password" class="form-control" name="password" placeholder="Password">
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2" for="pwd">
             <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
          </label>
          <div class="col-sm-10">
            <input type="password" class="form-control" name="password" placeholder="Retype password">
          </div>
        </div>
            <button type="submit" class="btn btn-default" onclick="otvoristranicu('kategorije.jsp')">Continue</button>
      </form>
    </section>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>