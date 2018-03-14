<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>LittleLend</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/commonstyle.css">
           <!-- jQuery library -->
                <script  src="js/jquery.js"></script>
                <!-- Latest compiled JavaScript -->
               <script src="js/bootstrap.js"></script>
                <script src="js/common.js"></script>
                <title>LittleLend.com</title>
    </head>
     
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">                                   
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        
        <a href="index.jsp" class="navbar-brand header-font" href="#">LittleLend</a>
        </div>
        <div class="navbar-collapse collapse">  
          <ul class="nav navbar-nav navbar-right"> 
           <%
     
           response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
           response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
           response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
           response.setHeader("Pragma","no-cache");
           if(session.getAttribute("userbean")==null)
          {
        	  response.sendRedirect("login.jsp");
          }
        	  	   
        	  %>
           <li><a href="#" />HI!&nbsp; ${userbean.firstname}</a></li> 
          
         
             <li><form action="LoginServlet" method="GET"><button class="logout">logout</button></form></li>
          </ul>
        </div>   			      		 
  </div>
</div>
</html>