<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <section id="novi-post">
      <h2 class="line-title"><span>New post</span></h2>
      <div class="post-forma">
        <form role="form" method="post" action="add" enctype="multipart/form-data">
         <div class="form-group">
          <input type="text" class="form-control" name="kategorija" placeholder="Category">
          <textarea class="form-control" rows="15" name="tekst" id="post"></textarea>
          <input type="file" name="file" />
          <button type="submit" class="btn btn-default">Publish</button>
        </div>
        </form>
      </div>
    </section>
