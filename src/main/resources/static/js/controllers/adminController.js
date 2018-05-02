app.controller('adminController', function($scope,$window,$http,$rootScope) {
	console.log("Inside admin controller");
   $scope.users	=	"";
   $('#toggle-one').bootstrapToggle();
	$http.get("/user/getUsers")
    .then(function(response) {
    	console.log(response.data)
    	$scope.users	=	response.data;
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
        console.log("Somenthing went wrong")
    });

});