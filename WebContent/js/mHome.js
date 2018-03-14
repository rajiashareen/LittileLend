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
   });
   
     $("#fur").click(function(){
	   var term1 = $('#fur').val();
	   $("#search").val(term1);
	   var products = ["Sofa & Couches", "Dinning Table", "Multiuse-Desks", "Bookcase", "Bedroom sets"];
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
   });
   
    $("#per").click(function(){
	   var term2 = $('#per').val();
	   $("#search").val(term2);
	   var products = ["Clothes", "Cosmetics", "Footware", "Bags/purses"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Clothes" || $(this).val() == "Cosmetics" || $(this).val() == "Footware" || $(this).val() == "Bags/purses" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   });
   
    $("#gad").click(function(){
	   var term3 = $('#gad').val();
	   $("#search").val(term3);
	   var products = ["Phone", "Computer", "Accesories", "Watches"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Phone" || $(this).val() == "Computer" || $(this).val() == "Accesories" || $(this).val() == "Watches" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   });
   
   
     $("#repa").click(function(){
	   var term2 = $('#repa').val();
	   $("#search").val(term2);
	   var products = ["Screw-Driver", "Ladder", "Circuit", "Machines"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Clothes" || $(this).val() == "Cosmetics" || $(this).val() == "Footware" || $(this).val() == "Bags/purses" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   });
   
   
   
   
   
     $("#part").click(function(){
	   var term2 = $('#part').val();
	   $("#search").val(term2);
	   var products = ["Decoration", "Mats", "Kitchenware", "Lights"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Decoration" || $(this).val() == "Mats" || $(this).val() == "Kitchenware" || $(this).val() == "Lights" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   });
   
   
   
   
     $("#vehi").click(function(){
	   var term2 = $('#vehi').val();
	   $("#search").val(term2);
	   var products = ["Car", "Tempo", "Bike", "Truck"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "Car" || $(this).val() == "Tempo" || $(this).val() == "Truck"  ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   });
   
   
   
   $("#hol").click(function(){
	   var term2 = $('#hol').val();
	   $("#search").val(term2);
	   var products = ["umbrella", "Tents", "Firstaid-kit", "Householdstuff"];
	   var option = '';
	   for (var i=0;i<products.length;i++){
	      option += '<option value="'+ products[i] + '">' + products[i] + '</option>';
	   }
	   $('#dropdownlist').append(option);
	   $("#dropdownlist").change(function(){
		   if ($(this).val() == "umbrella" || $(this).val() == "Tents" || $(this).val() == "Firstaid-kit" || $(this).val() == "Householdstuff" ){
			   
			      $("#dropdownlist").val(); 
		   } 
	   })
   });
   
   
   
});



