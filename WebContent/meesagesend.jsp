<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="insideheader.jsp" %>
 <form class="form-horizontal" method="post" action="MainHome">
<div id="postdetails">
<h3>Posting</h3>

<c:if test="${itemuserbean ne null && !empty itemuserbean}">                                    <!-- Items posted borrower details and item details -->
<input type="hidden" name="itemval" value="<c:out value='${itemuserbean.firstname}'/>">
<input type="hidden" name="itemval" value="<c:out value='${itemuserbean.firstname}'/>">
<table id="postdetailstable">
<tr><td id="cattd">Posted by:</td><td name="postedby" td colspan="3"  value="<c:out value='${itemuserbean.firstname}'/>" >${itemuserbean.firstname}</td><tr>
<tr><td id="cattd">Category:</td><td name="categorymess" td colspan="3"  value="<c:out value='${itemuserbean.category}'/>" >${itemuserbean.category}</td><tr>
<tr><td id="cattd">Item:</td><td name="itemmess" td colspan="3"  value="<c:out value='${itemuserbean.productname}'/>" >${itemuserbean.productname}</td><tr>
<tr><td id="cattd">Description:</td><td name="descriptionmessage" td colspan="3"  value="<c:out value='${itemuserbean.description}'/>" >${itemuserbean.description}</td><tr>
<tr><td id="cattd">Start date:</td><td name="strmessage" td colspan="3"  value="<c:out value='${itemuserbean.startdate}'/>" >${itemuserbean.startdate}</td><tr>
<tr><td id="cattd">End date:</td><td name="endmessage" td colspan="3"  value="<c:out value='${itemuserbean.enddate}'/>" >${itemuserbean.enddate}</td><tr>
<tr><td id="cattd">City:</td><td name="citymessage" td colspan="3"  value="<c:out value='${itemuserbean.city}'/>" >${itemuserbean.city}</td><tr>

</table>

</c:if>
</div>
<div id="lendermessage">
<h3>Lender Details</h1>                                                                          <!-- Lender details -->
<c:if test="${userbean ne null && !empty userbean}">
<label id="catmessage" for="catemess">Name</label> <input id="catemess"  name="categorymess" value="<c:out value='${userbean.firstname}'/>"><br>
<label id="catmessage" for="catemess">Email</label> <input id="catemess"  name="categorymess" value="<c:out value='${userbean.email}'/>"><br>	
<label id="catmessage" for="catemess">Message</label><br>
 <textarea id="messageby" name="messageconte" rows="4" cols="40" required="required"></textarea><br>
    <h4 id="dmessage"><c:if test="${not empty Messageblank}">
   <c:out value="${Messageblank}"/>
</c:if></h4> 
 <button id="sendmessage"  type="submit" name="messagesend" value="messagesend"/> Send</button>
</c:if>	
</div>



</body>
</form>
<%@ include file="footer.jsp" %> 
</html>