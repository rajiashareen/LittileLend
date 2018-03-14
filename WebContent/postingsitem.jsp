<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="insideheader.jsp" %>


<div id="postingbody">
<h3 id="postin">Postings</h3>
	<c:if test="${itemlist ne null && !empty itemlist}">  
	<c:set var="userbean" value="${userbean}"/>
	<c:if test="${userbean ne null && !empty userbean}" >
		<c:forEach items="${itemlist}" var="itembeanall">
	                                                  
	                                                                       
	                                                  
<form id="itemposting"  action="MainHome" method="post">
<input type="hidden" name="itemval" value="<c:out value='${itembeanall.itemid}'/>">
<input type="hidden" name="bfname" value="<c:out value='${itembeanall.firstname}'/>">
<input type="hidden" name="bemail" value="<c:out value='${itembeanall.email}'/>">
<input type="hidden" name="bcity" value="<c:out value='${itembeanall.city}'/>">
<input type="hidden" name="category" value="<c:out value='${itembeanall.category}'/>">
<input type="hidden" name="item" value="<c:out value='${itembeanall.productname}'/>">
<input type="hidden" name="description" value="<c:out value='${itembeanall.description}'/>">
<input type="hidden" name="startdate" value="<c:out value='${itembeanall.startdate}'/>">
<input type="hidden" name="endate" value="<c:out value='${itembeanall.enddate}'/>">
<input type="hidden" name="biid" value="<c:out value='${itembeanall.borrowerid}'/>">
<input type="hidden" name="biid" value="<c:out value='${itembeanall.flag}'/>">

                                               <!-- Getting all item postings--> 

<table border="1">
<tr><td id="cattd">Posted by:</td><td name="postedby"  colspan="3"  value="<c:out value='${itembeanall.firstname}'/>" >${itembeanall.firstname}</td><tr>
<tr><td id="catitem">Item :</td><td    colspan="3"s id="itemwant" name="itemwant">  ${itembeanall.productname}</td><td></td></tr>

<tr><td id="cattd">Category :</td><td name="cate"  colspan="3"   value="<c:out value='${itembeanall.category}'/>">${itembeanall.category}</td></tr>
 <c:choose>
    <c:when test="${userbean.id == itembeanall.borrowerid  }">
         <tr><td id="startdesc">Description :<td colspan="4" id="itemdescri" name="itemdescri"> ${itembeanall.description}</td></tr>
    </c:when>
      <c:when test="${ userbean.id == itembeanall.borrowerid  && itembeanall.flag =='Flagged' }">
<tr><td id="startdesc">Description :<td colspan="3" id="itemdescri" name="itemdescri"> ${itembeanall.description}</td><td id="lendbutton"><button id="lend"  type="submit" name="messagepost" value="messagepost"/> Lend</button></td> <td id="flaggedbutton"><button id="flag"  type="submit" name="flaggedpost" value="flaggedpost" disabled="disabled"/> Post Flagged</button></td></tr>

    </c:when>  
     <c:when test="${ userbean.id != itembeanall.borrowerid  && itembeanall.flag =='Flagged' }">
<tr><td id="startdesc">Description :<td colspan="3" id="itemdescri" name="itemdescri"> ${itembeanall.description}</td><td id="lendbutton"><button id="lend"  type="submit" name="messagepost" value="messagepost"/> Lend</button></td> <td id="flaggedbutton"><button id="flag"  type="submit" name="flaggedpost" value="flaggedpost"/> ${itembeanall.flag}</button></td></tr>

    </c:when>
         <c:when test="${ userbean.id != itembeanall.borrowerid  && itembeanall.flag =='Flag' }">
<tr><td id="startdesc">Description :<td colspan="3" id="itemdescri" name="itemdescri"> ${itembeanall.description}</td><td id="lendbutton"><button id="lend"  type="submit" name="messagepost" value="messagepost"/> Lend</button></td> <td id="flagbutton"><button id="flag"  type="submit" name="flagpost" value="flagpost"/> ${itembeanall.flag}</button></td></tr>

    </c:when>
    <c:otherwise>
<tr><td id="startdesc">Description :<td colspan="2" id="itemdescri" name="itemdescri"> ${itembeanall.description}</td><td id="lendbutton"><button id="lend"  type="submit" name="messagepost" value="messagepost"/> Lend</button></td> <td id="flagbutton"><button id="flag"  type="submit" name="flagpost" value="flagpost"/> ${itembeanall.flag}</button></td></tr>
    </c:otherwise>
</c:choose>

<tr><td id="startcat">Start Date :</td><td id="stda" name="stda">${itembeanall.startdate}</td><td  id="catend"> End Date :</td><td id="endda" name="endda"> ${itembeanall.enddate}</td></tr> 
</table>
</form>
</c:forEach>
</c:if>
</c:if>
</div>

                                                 <!-- Getting all looged user items--> 
<div id="mypostingbody" >
<h3 id="mp">My Postings</h3>
	<c:if test="${itemabeanlist ne null && !empty itemabeanlist}">
		<c:forEach items="${itemabeanlist}" var="itembeans">
<form id="itempostingmine" action="MainHome" method="post">
<input type="hidden" name="key" value="<c:out value='${itembeans.itemid}'/>">

<table border="1">
<tr><td id="cattd">Category :</td><td >${itembeans.category}</td><td id="catitem">Item :</td><td id="itemwant">  ${itembeans.productname}</td><td></td></tr>
<tr><td id="startdesc">Description :<td colspan="3"> ${itembeans.description}</td><td id="lendbutton"><button id="deletepost" name="deletepost" value="deletepost"type="submit">Delete</button></td></tr>
<tr><td id="startcat">Start Date :</td><td>${itembeans.startdate}</td><td id="catend"> End Date :</td><td> ${itembeans.enddate}</td><td></td></tr> 
</table>
</form>
</c:forEach>
</c:if>
</div>
</body>
<%@ include file="footer.jsp" %> 
</html>