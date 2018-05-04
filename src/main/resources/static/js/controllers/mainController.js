app.controller('mainController', function($scope,$window,$http,$rootScope) {
	console.log("Inside main controller");
 	$rootScope.user	=	"";
 	$scope.isAdmin	=	false;
	$scope.loginError	=	false;
	console.log("EL valor de formSent: "+formSent)
	if(formSent)
		$window.location.href = '#!addDocs';

	$http.get("/user/getUser")
    .then(function(response) {
    	$rootScope.user	= response.data;
    	if($rootScope.user.role==0)
    	 	$scope.isAdmin	=	true;

    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
        console.log("Somenthing went wrong")
		$window.location.href = '/';

    });

 
	$scope.logout =	function(){
		//$window.location.href = '#!register';
		console.log("trying to logout ")
 		$http.get("/user/logout")
	    .then(function(response) {
	    	console.log(response.data)
			$window.location.href = '/';
	    }, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
	    });
		//$window.location.href = 'html/main.htm';
	}

});