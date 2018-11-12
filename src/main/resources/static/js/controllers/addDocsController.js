app.controller('addDocsController', ['$scope','ngTableParams','$filter','$window','$http','$base64','$mdDialog','$timeout' ,function($scope,ngTableParams,$filter,$window,$http,$base64,$mdDialog,$timeout,$rootScope) {
	console.log(" addDocs controller");
	$scope.comments	=	"";
	$scope.docName	=	"";
	$scope.generalData	=	{ "docTypeChoosed":"object"};
	$scope.loadSuccess	=	false;
	var documentEntity	=	  {
			fileName:"",
			fileComments:"",
			documentName:""
		};
	console.log("EL valor de formSent: "+formSent)
	if(formSent){
		$scope.loadSuccess	=	true;
		$timeout(function () {
			$scope.loadSuccess	=	false;
	    }, 2000);
		

	}
  $http.get("/catalogs/getDocuments")
    .then(function(response) {
    	console.log(response.data)
		$scope.docs	=	response.data;
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
        console.log("Somenthing went wrong")
	}); 
	$http.get("/document/getDocuments")
    .then(function(response) {
    	console.log(response.data)
    	$scope.catalogs	=	response.data;
    	if($scope.catalogsTable!=undefined )
			 $scope.catalogsTable.reload();
    	$scope.catalogsTable = new ngTableParams({
    	       page: 1,
    	       count: 100
    	   }, {
    	       total: $scope.catalogs.length, 
    	       getData: function ($defer, params) {
    	    	   $scope.datat = params.sorting() ? $filter('orderBy')($scope.catalogs, params.orderBy()) : $scope.catalogs;
    	    	   $scope.datat = params.filter() ? $filter('filter')($scope.datat, params.filter()) : $scope.datat;
    	    	   $scope.datat = $scope.datat.slice((params.page() - 1) * params.count(), params.page() * params.count());
    	    	   $defer.resolve($scope.datat);
    	    	}
		   });

    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
        console.log("Somenthing went wrong")
      
	});
	$scope.save = function (form) {
		$http.get("/document/attachedImageInfo?docName="+$scope.docName+"&comments="+$scope.comments+"&docType="+$scope.generalData.docTypeChoosed.id)
	    .then(function(response) {
	    	console.log(response.data)
	    
	    }, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
	    });	    
 	  
	  
	  
	    }
	 
	$scope.remove = function(id){
		console.log("EL id es: "+id)
		  $http.get("/document/remove?id="+id)
	    .then(function(response) {
			$window.location.href = '#!addDocs';

		}, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
		}); 
	}
 
}]);