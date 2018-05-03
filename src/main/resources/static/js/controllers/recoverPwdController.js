app.controller('recoverPwdController', function($scope,$window,$http,$rootScope,$mdDialog) {
	console.log("Inside register controller");
	$scope.email	=	"";
	$scope.notFilledFields	=	false;
	$scope.emailNotValid	=	false;

	$scope.recover =	function(){
		console.log("email value: "+$scope.email)
		console.log("name value: "+$scope.name)
		 
		if($scope.email == ""){
			console.log("Inside email vacio")
			$scope.notFilledFields	=	true;
				return;
		}
		$scope.notFilledFields	=	false;

		if(!validateEmail($scope.email)){
			$scope.emailNotValid	=	true;
			return;
		}
		$scope.emailNotValid	=	false;
		
		   $mdDialog.show(
				      $mdDialog.alert()
				        .parent(angular.element(document.querySelector('#popupContainer')))
				        .clickOutsideToClose(true)
				        .title('Informacion')
				        .textContent('Se ha enviado un correo electronico con las credenciales a la cuenta que has ingresado, Gracias.')
				        .ariaLabel('Alert Dialog Demo')
				        .ok('Salir')
				        
				    ).then(function(i){
		    			$window.location.href = '/';
				      });;
		$http.get("/user/recover?"+"mail="+$scope.email)
	    .then(function(response) {
	    	console.log(response.data)
	    	
	    }, function(response) {
	        //Second function handles error
	        console.log("Somenthing went wrong")
//	        $mdDialog.show(
//				      $mdDialog.alert()
//				        .parent(angular.element(document.querySelector('#popupContainer')))
//				        .clickOutsideToClose(true)
//				        .title('Informacion')
//				        .textContent('Por el momento el servicio no esta disponible, por favor intenta mas tarde. Gracias.')
//				        .ariaLabel('Alert Dialog Demo')
//				        .ok('Salir')
//				        
//				    );
	    });
		 
		console.log("Campos validos...")
	}

	function validateEmail(email) {
		  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		  return re.test(email);
		}
});