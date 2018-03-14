<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<head>
<script src="js/jquery.js"></script>
                <!-- Latest compiled JavaScript -->
               <script src="js/bootstrap.js"></script>
               <script src="js/common.js"></script>
               <script src="js/registerpassword.js"></script>
</head>

<div class="containerregister">
  <div class="password-info-error">
<ul>
<li id="letter" class="invalid">At least <strong>one lowercase alphabet</strong></li>
<li id="capital" class="invalid">At least <strong>one uppercase alphabet</strong></li>
<li id="number" class="invalid">At least <strong>one number</strong></li>
<li id="special" class="invalid">At least <strong>one special character(!,%,&,@,#,$,^,*,?,_,~)</strong></li>
<li id="length" class="invalid">Be at least <strong>6 characters</strong></li>
</ul>
</div>
  <form class="form-horizontal" method = "post"  action="LoginServlet">

    <div class="form-group">
      <label class="control-label col-sm-2" for="firstname"></label>
      <div class="col-sm-7">
        <input type="text" class="form-control" id="firstname" placeholder="Enter firstname" name="firstname" required >
        
      </div>
    </div>
    
     <div class="form-group">
      <label class="control-label col-sm-2" for="lastname"></span></label>
      <div class="col-sm-7">          
        <input type="text" class="form-control" id="lastname" placeholder="Enter lastname" name="lastname" required>
      </div>
    </div>

    <div class="form-group">
      <label class="control-label col-sm-2" for="email"></span></label>
      <div class="col-sm-7">          
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
      </div>
    </div>

 <div class="form-group"  >
      <label class="control-label col-sm-2" for="registerpassword"></span></label>
      <div class="col-sm-7">          
        <input type="password" class="form-control" id="registerpassword" placeholder="Enter password" name="password">
      </div>
    </div>


    
     <div class="form-group">
      <label class="control-label col-sm-2" for="address"></span></label>
      <div class="col-sm-7">          
        <input type="text" class="form-control" id="address" placeholder="Enter address" name="address" required>
      </div>
    </div>
 <div class="form-group">
      <label class="control-label col-sm-2" for="city"></span></label>
      <div class="col-sm-7">          
        <input type="text" class="form-control" id="city" placeholder="Enter city" name="city" required>
      </div>
    </div>

  <div class="form-group">
      <label class="control-label col-sm-2" for="zip"></span></label>
      <div class="col-sm-7">          
        <input type="text" class="form-control" id="zip"  type=number placeholder="Enter zipcode" name="zipcode" required>
      </div>
    </div>   
         
      <div class="form-group">
      <label class="control-label col-sm-2" for="phone"></span></label>
      <div class="col-sm-7">          
        <input type="text" class="form-control" id="phone"  type=number placeholder="Enter Mobile number" name="phone" required>
      </div>
    </div>   
    <div class="form-group"> 
    
        <button type="submit"  name="action"  id="submit" value="register" class="ReBtn" >Register
        </button>
       <a href="login.jsp" id="mem">Already member?  Login</a>   
    </div>
     
                <h6><c:if test="${not empty errordisplayMessage}">
   <c:out value="${errordisplayMessage}"/>
</c:if></h6> 
  </form>
 </div>

</body>
<%@ include file="footer.jsp" %> 

</html>