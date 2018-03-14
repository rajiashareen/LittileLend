<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="adminheader.jsp" %>

<div id="adminhome" >
<h3>Flag Posts</h3>
	<c:if test="${itemlistadmin ne null && !empty itemlistadmin}">                  <!-- Getting all Flagged post--> 
		<c:forEach items="${itemlistadmin}" var="itembeansadmin">
<form id="itempostingmine" action="MainHome" method="post">
<input type="hidden" name="deletekey" value="<c:out value='${itembeansadmin.itemid}'/>">

<table border="1">
<tr><td id="cattd">Posted by:</td><td name="postedby"  colspan="3"  value="<c:out value='${itembeansadmin.firstname}'/>" >${itembeansadmin.firstname}</td><tr>
<tr><td id="cattd">Category :</td><td >${itembeansadmin.category}</td><td id="catitem">Item :</td><td id="itemwant">  ${itembeansadmin.productname}</td><td></td></tr>
<tr><td id="startdesc">Description :<td colspan="3"> ${itembeansadmin.description}</td><td id="lendbutton"><button name="deleteflag" value="deleteflag" type="submit">Delete</button></td></tr>
<tr><td id="startcat">Start Date :</td><td>${itembeansadmin.startdate}</td><td id="catend"> End Date :</td><td> ${itembeansadmin.enddate}</td><td></td></tr> 
</table>
</form>
</c:forEach>
</c:if>
</div>
</body>
<%@ include file="footer.jsp" %> 
</html>