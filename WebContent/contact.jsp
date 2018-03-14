<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<div class="containercontact">
  <form  method="post" action="MainHome">

    <div class="form-group">
      <label class="control-label col-sm-2" for="contactusername"></label>
      <div class="col-sm-7">
         <input type="text" class="form-control" id="contactusername"  placeholder="Enter Fullname"  name="contactusername" required>
      </div>
    </div>

     <div class="form-group">
     <label class="control-label col-sm-2" for="contactEmailid"></label>
      <div class="col-sm-7">
         <input type="text" class="form-control" id="contactEmailid"  placeholder="Enter Email-Id"  name="contactEmailid" required>
      </div>
      </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="contactbox"></label><br>
      <div class="col-sm-7">
         <input type="textbox" class="form-control" id="contactbox" placeholder="Message"  name="contactbox" required>
      </div>
      
    <div class="form-group">        
      <div class="col-sm-offset-4 col-sm-4">
        <button type="submit"  name="contactaction" value="contactaction"  >Contact us
        </button>
        
      </div>
    </div>
       <h6 id="sendemailmessage"><c:if test="${not empty sendEmail}">    <!-- displays message of mail sent-->                     
   <c:out value="${sendEmail}"/>
</c:if></h6>
  </form>
 </div>

 <%@ include file="footer.jsp" %> 
</html>