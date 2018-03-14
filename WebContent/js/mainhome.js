$(document).ready(function (){
	
   $("#elec").click(function(){
	   var term = $('#elec').val();
	   $("#search").val(term); 
	   var products = ["Refregirator", "Washer", "Dryer", "MicoroWave", "Dishwasher","Floor Care"];
	   var option = '';
	   
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	    $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Refregirator" || $(this).val() == "Washer" || $(this).val() == "Dryer" || $(this).val() == "MicoroWave" || $(this).val() == "Dishwasher" || $(this).val() == "Floor Care"){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
     $("#fur").click(function(){
	   var term1 = $('#fur').val();
	   $("#search").val(term1);
	   var products = ["Sofa sets", "Dinning Table", "Multiuse-Desks", "Bookcase", "Bedroom sets"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Sofa sets" || $(this).val() == "Dinning Table" || $(this).val() == "Multiuse-Desks" || $(this).val() == "Bookcase" || $(this).val() == "Bedroom sets" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
    $("#per").click(function(){
	   var term3= $('#per').val();
	   $("#search").val(term3);
	   var products = ["Clothes", "Cosmetics", "Footware", "Bags/purses"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Clothes" || $(this).val() == "Cosmetics" || $(this).val() == "Footware" || $(this).val() == "Bags/purses" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
    $("#gad").click(function(){
	   var term4 = $('#gad').val();
	   $("#search").val(term4);
	   var products = ["Phone", "Computer", "Accesories", "Watches"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Phone" || $(this).val() == "Computer" || $(this).val() == "Accesories" || $(this).val() == "Watches" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
   
     $("#repa").click(function(){
	   var term5 = $('#repa').val();
	   $("#search").val(term5);
	   var products = ["Screw-Driver", "Ladder", "Circuit", "Machines"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Clothes" || $(this).val() == "Cosmetics" || $(this).val() == "Footware" || $(this).val() == "Bags/purses" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
   
   
   
   
     $("#part").click(function(){
	   var term6 = $('#part').val();
	   $("#search").val(term6);
	   var products = ["Decoration", "Mats", "Kitchenware", "Lights"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Decoration" || $(this).val() == "Mats" || $(this).val() == "Kitchenware" || $(this).val() == "Lights" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
   
   
   
     $("#vehi").click(function(){
	   var term7 = $('#vehi').val();
	   $("#search").val(term7);
	   var products = ["Car", "Tempo", "Bike", "Truck"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Car" || $(this).val() == "Tempo" || $(this).val() == "Truck"  ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
   
   
   $("#hol").click(function(){
	   var term8 = $('#hol').val();
	   $("#search").val(term8);
	   var products = ["umbrella", "Tents", "Firstaid-kit", "Householdstuff"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').empty();
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "umbrella" || $(this).val() == "Tents" || $(this).val() == "Firstaid-kit" || $(this).val() == "Householdstuff" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   })
   
   
   
});
function TDate() {
	
    var UserDate = document.getElementById("start").value;
    var UserDate1 = new Date(UserDate); 
    $("#start").css("border", "4px solid white");
    var ToDate = new Date();
    console.log(ToDate);
    if ((UserDate1).getTime() < ToDate.getTime()) {
    	$("#mainaction").disable=true;
    	alert("ksd");
    	$("#start").css("border", "4px solid #e60000");
          return false;
     }
    else
    	{
    $("#start").css("border", "4px solid white");
    $("#mainaction").disable=false;
    return true;
    	}
}



function TendDate() {
    var UserDate = document.getElementById("end").value;
    var UserDate1 = new Date(UserDate);
    $("#end").css("border", "4px solid white");
    var message=document.getElementById("endmessage");
    var ToDate = new Date();
   
    if ((UserDate1).getTime() < ToDate.getTime()) {
    	$("#mainaction").disable=true;
    	$("#end").css("border", "4px solid #e60000");
          return false;
     }
    else
    	{
    $("#end").css("border", "4px solid white");
    $("#mainaction").disable=false;
    return true;
    	}
}
