function registerpassword()
{
	
	alert("hii");
	
	   var passowrd = document.getElementById("registerpassword")
	   var repassowrd = document.getElementById("repassword").value;
	   var letterNumber = "/^[0-9a-zA-Z]+$/"; 
	   if(passowrd.value.matches(letterNumber))
		   {
		       
		   password.css("border","4px solid green");
		   }
	   else
		   {
		   password.css("border","4px red");
		   }
		   
	   
	   



}
























/*$(document).ready(function() {
  $("#registerpassword").change(function(){
	  if($('#repassword').value==$('#registerpassword').value){
		  
		  $("#repassword").css("border","4px solid green");
	  }
	  else{
		  

	  }
  }); 
});*/



