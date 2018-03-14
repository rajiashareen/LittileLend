<%@page import="com.littlelend.dto.Userbean"%>
<%@page import="com.littlelend.dto.Itembean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="insideheader.jsp" %>

 <form class="form-horizontal" method="post" action="MainHome">
<div id="back" class="black">

<input type="text" id="search" name="search" placeholder="Select below Category"  required="required">          <!-- All fields are required -->
 <label id="drop" for="itemdrop">Product  
</label>
<select class="itemdrop" id="dropdownlist" name="dropdownlistvalue">
</select>
<label id="star" for="start">Start Date :(MM-DD-YYYY) </label>  
<input name="startdate" id="start" type="Date" onchange="TDate()" required="required" />    

 <label id="en" for="end">End Date : :(MM-DD-YYYY)
</label><input id="end" name="endate"  type="Date" onchange="TendDate()"  required="required" />

  </div>
   <h4 id="dmessage"><c:if test="${not empty detailsMessage}">
   <c:out value="${detailsMessage}"/>
</c:if></h4> 
                                              <!-- Drop downs -->
  <div id="a1">
<div class="dropdown">
  <button class="dropbtn" id="elec" name="elect" value="Electronics" type="button"  ><img id="img1" src="./images/appliances.png"/><br>Electronics</button>
  <button class="dropbtn" id="fur" name="furni" value="Furniture" type="button"><img id="img2" src="./images/furniture.png"/><br>Furniture</button>
  <button class="dropbtn" id="per" name="personal" value="Personal" type="button"><img id="img3" src="./images/clothes.png"/><br>Personal</button>
  <button class="dropbtn" id="gad" name="gadgets" value="Gadgets" type="button"><img id="img4" src="./images/gadgets.png"/><br>Gadgets</button>
  
 </div> 
  
 <div class="dropdown1">
  <button class="dropbtn" id="repa" name="repair" value="Repair&Outdoor" type="button"><img id="img4" src="./images/moving.png"/><br>Repairs & Outdoors</button>
  <button class="dropbtn" id="part" name="party" value="Party" type="button"><img id="img5" src="./images/party.png"/><br>party</button>
  <button class="dropbtn" id="vehi" name="veh" value="Vehicle" type="button"><img id="img6" src="./images/veh.png"/><br>Vehicles</button>
  <button class="dropbtn" id="hol" name="holi" value="Holiday" type="button"><img id="img7" src="./images/holiday.png"/><br>Holiday</button>
 </div>

                                 <!-- Redirects to MainHome Servlet on post -->
                                 
 <button type="submit"  id="mainaction" name="mainaction" value="mainhome"  class="post">Post
        </button> 
    
 </div>
 <!-- Get  logged user data   -->
 <div id="a2">
   <label id="discrip" for="description" >Description </label><br>
   <textarea id="description" name="desriptionte" rows="4" cols="40"  required="required"></textarea><br>
   <label for="cd">Contact details</label><br>
    <label id="finame" for="fname" name="firstname"> Name</label> <input type="text" id="fname" value=" ${userbean.firstname} &nbsp; ${userbean.lastname}"> <br>
    <label id="lsname" for="lname"  name="lastname">Email</label> <input type="text" id="lname" value=" ${userbean.email}"><br>
    <label id="numb" for="phone"  name="phone">Phone  </label> <input type="text" id="homephone" value=" ${userbean.phone}"> <br>
   <label id="addres" for="homeaddress"  >Address</label> <br>
    <textarea id="homeaddress" rows="4" cols="40" name="homeaddress" name="homeaddress"  required>${userbean.address}</textarea> <br>
    <label id="cit" for="homecity" name="city">City</label> <input type="text" id="homecity" value=" ${userbean.city}"><br>
    <label id="zi" for="zip" name="zipcodehome">Zipcode</label> <input type="text" id="zipcodehome" value=" ${userbean.zip}"><br>
    
 </div>
 </form>
</body>
<%@ include file="footer.jsp" %> 
</html>