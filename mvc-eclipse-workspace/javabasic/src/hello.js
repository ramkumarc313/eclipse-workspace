var hello = function(msg){  
	print("Ramkumar");  
	var carName = "Volvo";
	print(carName);  

	var myObj, i, x = "";
	myObj = {
			"name":"John",
			"age":30,
			"cars":[ "Ford", "BMW", "Fiat" ]
	};

	for (i = 0; i < myObj.cars.length; i++) {
		x += myObj.cars[i] + "<br>";
		print(myObj.cars[i] );  


	}

};  
hello("Nashron");  

var hello1 = function(msg){  
	print("Ramkumar.C");  
	var carName = "Volvo";
	print(carName);  

	var myObj, i, x = "";
	myObj = {
			"name":"John",
			"age":30,
			"cars":[ "Ford", "BMW", "Fiat" ]
	};

	for (i = 0; i < myObj.cars.length; i++) {
		x += myObj.cars[i] + "<br>";
		print(myObj.cars[i] );  


	}

};  
hello1("Nashron");  


var myFunction=function() {
	var n = Date.now();
	print(n); 
};
myFunction("yes")