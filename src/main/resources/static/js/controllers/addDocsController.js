app.controller('addDocsController', ['$scope','ngTableParams','$filter','$window','$http','$base64','$mdDialog','$timeout' ,function($scope,ngTableParams,$filter,$window,$http,$base64,$mdDialog,$timeout,$rootScope) {
	console.log(" addDocs controller");
	$scope.comments	=	"";
	$scope.docName	=	"";
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
 
	$scope.save = function (form) {
		$http.get("/document/attachedImageInfo?docName="+$scope.docName+"&comments="+$scope.comments)
	    .then(function(response) {
	    	console.log(response.data)
	    
	    }, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
	    });	    
 	  
	  
	  
	    }
	 
	
 
}]);