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
	    //if (!$scope.contactForm.$valid) return;
	    
	    var url = form.attributes["target"];
	    $log.debug(url);
	  
	    $http
	      .post(url, { email: $scope.email, name: $scope.name })
	      .success(function (response) {
	        $log.debug(response);
	      })
	    }
	
	documentEntity.fileComments	=	"";
	
 
 	$scope.sendFile =	function(){
		console.log("Send file ")
		var fi	=	document.getElementById("loadFile").value;
		console.log("Fi is: "+fi)
		if(fi==""){
			 $mdDialog.show(
				      $mdDialog.alert()
				        .parent(angular.element(document.querySelector('#popupContainer')))
				        .clickOutsideToClose(true)
				        .title('Informacion')
				        .textContent('Selecciona un archivo por favor.')
				        .ariaLabel('Alert Dialog Demo')
				        .ok('Salir')
				        
				    ).then(function(i){
		    			

				      });
			 return;
		}
		console.log("Archivo seleccionado");	
		var fd = new FormData();
		var blob = new Blob([$scope.markdown], {type: 'multipart/form-data'});
		documentEntity.fileName =	fi;
		documentEntity.fileComments	=	$scope.comments;
		documentEntity.documentName	=	$scope.docName;
		var toS	=	$base64.encode(JSON.stringify(documentEntity))
		console.log("Print..."+toS)	
		var file = new File([blob],  toS);
		console.log("File: "+file)
		fd.append('file', file);
		fd.append('from', 'markdown');
		fd.append('to', 'pdf');
		$http.post('/document/addDoc', fd, {
		    transformRequest: angular.identity,
		    headers: {'Content-Type': undefined},
		    responseType: 'arraybuffer'
		})
		.success(function(response){
		 // var b = new Blob([response], { type: 'application/vnd.openxmlformats-officedocument.wordprocessingml.document' });
		  //FileSaver.saveAs(b, 'abc.docx');
		})
		.error(function(res){
		  console.log(res);
		});
	}
}]);