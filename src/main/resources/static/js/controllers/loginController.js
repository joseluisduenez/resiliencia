app.controller('loginController', function($scope,$window,$http,$rootScope) {
	console.log("Inside login controller");
	$scope.username	=	"";
	$scope.password	=	"";
	$rootScope.user	=	{
			allowed:false,
			objectUser:""
	}
	$scope.loginError	=	false;
	$scope.login =	function(){
		//$window.location.href = 'html/register.htm';

		console.log("username: "+$scope.username)
		console.log("password: "+$scope.password)
		$http.get("/user/login?username="+$scope.username+"&pwd="+$scope.password)
	    .then(function(response) {
	    	console.log(response.data)
	    	if(response.data.allowed === true){
	    		console.log("allow entrance to application")
	    		$rootScope.user.allowed		=	true;
	    		$rootScope.user.objectUser	=	response.data.user;
	    		if(response.data.user.role == 0)
	    			$window.location.href = 'html/main.htm';
	    		else if(response.data.user.role == 1)
	    			$window.location.href = 'html/adminMain.htm';

	    	}
	    	else{
	    		$scope.loginError	=	true;

	    	}
	    }, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
	    });
		//$window.location.href = 'html/main.htm';
	}

});