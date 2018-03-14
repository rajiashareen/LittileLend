$(document).ready(function(){
	
	$('#registerpassword').keyup(function() {
		  checkPasswordStrength($(this));
		});
	  
	  function checkPasswordStrength(element){
		  var strength=0;
		  if ($(element).val().length >= 6){ 
			  strength += 1;
			  $("#length").removeClass("invalid");
			  $("#length").addClass("valid");
		  }
		  else{
			  $("#length").removeClass("valid");
			  $("#length").addClass("invalid");
		  }
		  if ($(element).val().match(/([a-z])/)){  
			  strength += 1;
			  $("#letter").removeClass("invalid");
			  $("#letter").addClass("valid");
			  }
		  else{
			  $("#letter").removeClass("valid");
			  $("#letter").addClass("invalid");
		  }
		  if ($(element).val().match(/([A-Z])/))   
			  {strength += 1;
			  $("#capital").removeClass("invalid");
			  $("#capital").addClass("valid");
			  }
		  else{
			  $("#capital").removeClass("valid");
			  $("#capital").addClass("invalid");
		  }
		  if ($(element).val().match(/([0-9])/))   
		  {strength += 1;
		  $("#number").removeClass("invalid");
		  $("#number").addClass("valid");
		  }
	  else{
		  $("#number").removeClass("valid");
		  $("#number").addClass("invalid");
	  }
		  
		  if ($(element).val().match(/([!,%,&,@,#,$,^,*,?,_,~])/)) { 
			  strength += 1;
			  $("#special").removeClass("invalid");
			  $("#special").addClass("valid");
		  }
		  else{
			  $("#special").removeClass("valid");
			  $("#special").addClass("invalid");
		  }
		  if(strength==5){
			  $(".password-info-error").hide();
		  }
		  else if(strength<4){
			  $(".password-info-error").show();
		  }
	  }
})