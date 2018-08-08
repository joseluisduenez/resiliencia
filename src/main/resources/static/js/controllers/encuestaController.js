app.controller('encuestaController' ,function($scope,ngTableParams,$filter,$window,$http,$rootScope,$mdDialog,$timeout) {
	console.log("Inside encuestaController  ");
  $scope.encuesta	=	{};
  $scope.subareas	=	{};
  $scope.preguntas	=	{};

  $scope.questionchoosed	=	false;
  $scope.responsechoosed	=	false;

	$scope.generalData	=	{ "id":"0", "createdAt":"","idUser":"","proyectoReciente":"","nombre":"","razonSocial":"","rfc":"","clasificationId":"","fechaConstitucion":"",
			"inicioOperacion":"","propertyTypeId":"","comentarios":"","calle":"","numero":"","colonia":"","codigoPostal":"","clasificationName":"","stateName":"Nuevo Leon","propertyName":""
									,"ciudadId":"","estadoId":"","pais":"","telefonoOficina":"","www":"","email":"","nombreDelContacto":"","telefonoDeContacto":"","emailDeContacto":"",
								"propertyChoosen":"object","city":"object","clasificationChoosen":"object","areachoosed":"object","subareachoosed":"object","preguntachoosed":"object"};
  $scope.catalogochoosed ="";
  $scope.namecatalog	=	"";
  $scope.ppregunta	=	"";
  $scope.spregunta	=	"";
  $scope.tpregunta	=	"";
  
  $scope.subareachoosed	=	false;
  $scope.areachoosed	=	{};
  $scope.sustentabilidad	=	{"sourceName":"extradata","idUser":"","sourceId":"","benefactor":"","porcentajeAnual":"","comentario":"","status":"1"};
  $http.get("/catalogs/getEncuesta")
  .then(function(response) {
  	console.log(response.data)
		$scope.encuesta	=	response.data;
  	console.log("Resultado encuesta")
  	console.log(JSON.stringify($scope.encuesta))
  }, function(response) {
      //Second function handles error
      $scope.content = "Something went wrong";
      console.log("Somenthing went wrong")
	}); 
  
   
  
 
	
 	 $scope.save =	function(id){
 		var checkedResponse = {
 			    id:"",
  			    number:0
  			};
 		var listaChecked = [];
 		 var larea	= $scope.encuesta.area.length;
 		 console.log("Longitud area: "+larea);
 		 for( areas=0; areas<larea;areas++){
 			 var lsubarea = $scope.encuesta.area[areas].subarea.length;
 			 console.log("lsubarea: "+lsubarea)
 			 for( sareas=0; sareas<lsubarea;sareas++){
 	 			 var lpregunta = $scope.encuesta.area[areas].subarea[sareas].pregunta.length;
 	 			 console.log("lpregunta: "+lpregunta)
 	 			 for( preguntait=0; preguntait<lpregunta;preguntait++){
 	 	 			 var lresponse = $scope.encuesta.area[areas].subarea[sareas].pregunta[preguntait].respuesta.length;
 	 	 			 console.log("lresponse: "+lresponse)
 	 	 			for( responseit=0; responseit<lresponse;responseit++){
 	 	 	 			 var id = $scope.encuesta.area[areas].subarea[sareas].pregunta[preguntait].respuesta[responseit].id;
 	 	 	 			 var name = $scope.encuesta.area[areas].subarea[sareas].pregunta[preguntait].respuesta[responseit].name;
 	 	 	 			 var number = $scope.encuesta.area[areas].subarea[sareas].pregunta[preguntait].respuesta[responseit].number;

 	 	 	 			 var ele = document.getElementById(id);
 	 	 	 			 if(ele!=null){
 	 	 	 				 if(ele.checked){
 	 	 	 	 	 			 console.log("Is checked: Id"+id+ " name: "+name+" number: "+number)
 	 	 	 	 	 		var checkedResponse = new Object();
 	 	 	 	 	 		checkedResponse.id = id;
 	 	 	 	 	 		checkedResponse.number = number;
 	 	 	 	 	 		listaChecked.push(checkedResponse);
 	 	 	 				 }
 	 	 	 			 }
 	 	 	 		 }
 	 	 		 }
 	 		 }
 		 }
 		 console.log("A enviar...")
 		 var objecttosend = new Object();
 		 objecttosend.lista =	listaChecked;
		 console.log(JSON.stringify(objecttosend));
	 
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