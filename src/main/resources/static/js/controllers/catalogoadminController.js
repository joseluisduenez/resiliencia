app.controller('catalogoadminController' ,function($scope,ngTableParams,$filter,$window,$http,$rootScope,$mdDialog,$timeout) {
	console.log("Inside catalogoadminController  ");
  $scope.areas	=	{};
	$scope.generalData	=	{ "id":"0", "createdAt":"","idUser":"","proyectoReciente":"","nombre":"","razonSocial":"","rfc":"","clasificationId":"","fechaConstitucion":"",
			"inicioOperacion":"","propertyTypeId":"","comentarios":"","calle":"","numero":"","colonia":"","codigoPostal":"","clasificationName":"","stateName":"Nuevo Leon","propertyName":""
									,"ciudadId":"","estadoId":"","pais":"","telefonoOficina":"","www":"","email":"","nombreDelContacto":"","telefonoDeContacto":"","emailDeContacto":"",
								"propertyChoosen":"object","city":"object","clasificationChoosen":"object"};
  $scope.catalogochoosed ="";
  $scope.namecatalog	=	"";
  $scope.subareachoosed	=	false;
  $scope.areachoosed	=	{};
  $scope.sustentabilidad	=	{"sourceName":"extradata","idUser":"","sourceId":"","benefactor":"","porcentajeAnual":"","comentario":"","status":"1"};
  $http.get("/catalogs/getArea")
  .then(function(response) {
  	console.log(response.data)
		$scope.areas	=	response.data;
  }, function(response) {
      //Second function handles error
      $scope.content = "Something went wrong";
      console.log("Somenthing went wrong")
	}); 
  $scope.loadcatalogSubArea = function(id){
		$http.get("/catalogs/getCatalog?catalog="+$scope.catalogochoosed+"&areaId="+$scope.generalData.clasificationChoosen.id)
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

	  
  }
  
	$scope.loadcatalog = function(id){
		  $scope.subareachoosed	=	false;

		console.log("catalogochooseds: "+$scope.catalogochoosed)
		if($scope.catalogochoosed==9){
			console.log("Id es nueve")
			  $scope.subareachoosed	=	true;
			$http.get("/catalogs/getCatalog?catalog="+$scope.catalogochoosed)
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


		}else{
		 	$http.get("/catalogs/getCatalog?catalog="+$scope.catalogochoosed)
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


		}
		  $http.get("/catalogs/getArea")
		  .then(function(response) {
		  	console.log(response.data)
				$scope.areas	=	response.data;
		  }, function(response) {
		      //Second function handles error
		      $scope.content = "Something went wrong";
		      console.log("Somenthing went wrong")
			}); 
	}
	$scope.remove = function(id){
		console.log("EL id es: "+id)
		  $http.get("/catalogs/removeCatalog?catalog="+$scope.catalogochoosed+"&id="+id)
	    .then(function(response) {
			$window.location.href = '#!catalogoadmin';

		}, function(response) {
	        //Second function handles error
	        $scope.content = "Something went wrong";
	        console.log("Somenthing went wrong")
		}); 
	}
 	 $scope.save =	function(id){
		console.log("  save "+JSON.stringify($scope.generalData.clasificationChoosen));
		  $http.get("/catalogs/addCatalog?catalog="+$scope.catalogochoosed+"&name="+$scope.namecatalog+"&areaId="+$scope.generalData.clasificationChoosen.id)
		    .then(function(response) {
		    	console.log(response.data)
		 		$window.location.href = '#!catalogoadmin';
		    }, function(response) {
		        //Second function handles error
		        $scope.content = "Something went wrong";
		        console.log("Somenthing went wrong")
			}); 

 
 	 
  
	} 
	function validateObject(){
		for (var key in $scope.addSustentabilidad) {
			if ($scope.addSustentabilidad.hasOwnProperty(key)) {
 				console.log(key + " -> " + $scope.addSustentabilidad[key]);
							console.log("key:"+key)
 				if(key =="clasificationId" || key =="propertyTypeId"||key =="id"|| key =="createdAt" || key =="idUser"|| key =="ciudadId"|| key =="estadoId"){
					console.log("key is id:"+key)
					continue;
				}
 				if($scope.addSustentabilidad[key]==""){
					console.log("returning false key:"+key)
					return false
					}
 					return true;
			}
		}
	}
 
});