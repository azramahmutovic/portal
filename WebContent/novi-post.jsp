<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="container">
  <div class="col-md-2"></div>
  <div class="col-md-8">
    <section id="novi-post">
      <h2>New post</h2>
      <div class="post-forma">
        <form role="form" method="post" action="add">
         <div class="form-group">
          <input type="text" class="form-control" name="kategorija" placeholder="Category">
          <textarea class="form-control" rows="15" name="tekst" id="post"></textarea>
          <button type="submit" class="btn btn-default">Publish</button>
        </div>
        </form>
      </div>
    </section>
  </div>
  <div class="col-md-2"></div>
</div>