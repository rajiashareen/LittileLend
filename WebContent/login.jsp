<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="header.jsp" %>

 <div class="container">
 <div class="col-md-4 col-xs-12">
</div>


  <form class="form-horizontal col-md-4 col-xs-12 container1" method="post" action="LoginServlet">
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="username"></label>
      <div class="col-sm-7">
        <input type="email" class="form-control" id="username" placeholder="Enter Email" name="username" required  >
      </div>
    </div>

    <div class="form-group" >
      <label class="control-label col-sm-2" for="password"></span></label>
      <div class="col-sm-7">          
        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
      </div>
    </div>


 <div class="col-md-4 col-xs-12">
</div>
    
    <div class="form-group">        
      <div class="col-sm-offset-4 col-sm-4">
        <button type="submit" name="loginaction" value="login" class="ReBtn" class="LBtn">Login
        </button>
      </div>
    </div>
   <h5><c:if test="${not empty errorMessage}">                   <!-- displays if email already exist-->                
   <c:out value="${errorMessage}"/>
</c:if></h5>
   </form>
  </div>
  
 </div>  
 </div>
</body>
<%@ include file="footer.jsp" %> 

</html>