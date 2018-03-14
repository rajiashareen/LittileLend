<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="insideheader.jsp" %>


<div id="receivedmessagebody">
<h4>Messages</h4>
	<c:if test="${userbean ne null && !empty userbean}">
	<c:if test="${messagereceivedlist ne null && !empty messagereceivedlist}">                         
		<c:forEach items="${messagereceivedlist}" var="messagesreceived" >

<form id="messageposting"  action="MainHome" method="post">
<input type="hidden" name="itemval" value="<c:out value='${messagesreceived.messageID}'/>">
<input type="hidden" name="bfname" value="<c:out value='${messagesreceived.mborrowerID}'/>">
<input type="hidden" name="bemail" value="<c:out value='${messagesreceived.mitemID}'/>">
<input type="hidden" name="bcity" value="<c:out value='${messagesreceived.messageContent}'/>">
<input type="hidden" name="category" value="<c:out value='${messagesreceived.mborrowerfname}'/>">
<input type="hidden" name="item" value="<c:out value='${messagesreceived.mborroweremail}'/>">
<input type="hidden" name="description" value="<c:out value='${messagesreceived.mitemname}'/>">

                                            <!-- Getting all the messages-->
<table id="Messagedisplay">
<tr><td id="cattd">Sent by:</td><td name="postedby" td colspan="4"  value="<c:out value='${messagesreceived.mborrowerfname}'/>" >${messagesreceived.mborrowerfname}</td><tr>
<tr><td id="recename">Message:</td><td name="postedby" td colspan="4"  value="<c:out value='${messagesreceived.messageContent}'/>" >${messagesreceived.messageContent}</td><tr>
<tr><td id="mdate">Date:</td><td name="postedby" td colspan="4"  value="<c:out value='${messagesreceived.messageDate}'/>" >${messagesreceived.messageDate}</td><tr>
<tr><td id="cattd">Futher Contact </td><td name="postedby" td colspan="4"  value="<c:out value='${messagesreceived.mborroweremail}'/>" >${messagesreceived.mborroweremail}</td><tr>

</table>
</form>
</c:forEach>
</c:if>
</c:if>

</div>
<div id="messagebody"> 
<h4>Sent</h4>
	<c:if test="${userbean ne null && !empty userbean}">
	<c:if test="${messagelist ne null && !empty messagelist}">
		<c:forEach items="${messagelist}" var="messages" >                                 

<form id="messageposting"  action="MainHome" method="post">
<input type="hidden" name="itemval" value="<c:out value='${messages.messageID}'/>">
<input type="hidden" name="bfname" value="<c:out value='${messages.mborrowerID}'/>">
<input type="hidden" name="bemail" value="<c:out value='${messages.mitemID}'/>">
<input type="hidden" name="bcity" value="<c:out value='${messages.messageContent}'/>">
<input type="hidden" name="category" value="<c:out value='${messages.mborrowerfname}'/>">
<input type="hidden" name="item" value="<c:out value='${messages.mborroweremail}'/>">
<input type="hidden" name="description" value="<c:out value='${messages.mitemname}'/>">

                                      <!-- Getting Sent  Messages -->
 
<table id="Messagedisplay">
<tr><td id="cattd">Sent by:</td><td name="postedby" td   value="<c:out value='${messagesreceived.mborrowerfname}'/>" >You</td> <td id="cattd">Sent to:</td><td name="postedby" td   value="<c:out value='${messages.mborrowerfname}'/>" >${messages.mborrowerfname}(${messages.mborroweremail})</td></tr>
<tr><td id="recename">Date:</td><td name="postedby" td colspan="3"  value="<c:out value='${messages.messageDate}'/>" >${messages.messageDate}</td></tr>
<tr><td id="recename">Message:</td><td name="postedby" td colspan="3"  value="<c:out value='${messages.messageContent}'/>" >${messages.messageContent}</td></tr>
</table>
</form>
</c:forEach>
</c:if>
</c:if>

</div>

</body>
</form>
<%@ include file="footer.jsp" %> 
</html>