app.controller('adminController', ['$scope','ngTableParams','$filter','$window','$http' ,function($scope,ngTableParams,$filter,$window,$http,$rootScope) {
	console.log("Inside admin controller");
/*	 $scope.users = [{"id":1,"first_name":"Philip","last_name":"Kim","email":"pkim0@mediafire.com","country":"Indonesia","ip_address":"29.107.35.8"},
         {"id":2,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":3,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":4,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":5,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":6,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":7,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":8,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":9,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":10,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":11,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":12,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":13,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":14,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":15,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":16,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":17,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":18,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":19,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":20,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
         {"id":21,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
         {"id":22,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
         {"id":50,"first_name":"Andrea","last_name":"Greene","email":"agreene4@fda.gov","country":"Russia","ip_address":"128.72.13.52"}];
  // $scope.usersTable	=	"";
   $scope.usersTable = new ngTableParams({
       page: 1,
       count: 10
   }, {
       total: $scope.users.length, 
       getData: function ($defer, params) {
    	   $scope.data = params.sorting() ? $filter('orderBy')($scope.users, params.orderBy()) : $scope.users;
    	   $scope.data = params.filter() ? $filter('filter')($scope.data, params.filter()) : $scope.data;
    	   $scope.data = $scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count());
    	   $defer.resolve($scope.data);
    	}
   });*/
	$http.get("/user/getUsers")
    .then(function(response) {
    	console.log(response.data)
    	$scope.users	=	response.data;
    	$scope.usersTable = new ngTableParams({
    	       page: 1,
    	       count: 10
    	   }, {
    	       total: $scope.users.length, 
    	       getData: function ($defer, params) {
    	    	   $scope.data = params.sorting() ? $filter('orderBy')($scope.users, params.orderBy()) : $scope.users;
    	    	   $scope.data = params.filter() ? $filter('filter')($scope.data, params.filter()) : $scope.data;
    	    	   $scope.data = $scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count());
    	    	   $defer.resolve($scope.data);
    	    	}
    	   });
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
        console.log("Somenthing went wrong")
      
    });

 	$scope.changeStatus =	function(id){
		console.log("change status "+id)
 		 $http.get("/user/activateUser?id="+id)
	    .then(function(response) {
	    	console.log(response.data)

	    }, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
	    }); 
		//$window.location.href = 'html/main.htm';
	}
	
	$scope.changeRole =	function(id){
		console.log("change role "+id)
 		 $http.get("/user/changeRole?id="+id)
	    .then(function(response) {
	    	console.log(response.data)

	    }, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
	    }); 
		//$window.location.href = 'html/main.htm';
	} 
}]);