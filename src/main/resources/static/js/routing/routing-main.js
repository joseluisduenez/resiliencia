var app = angular.module("resiliencia-main", ["ngRoute",'ngMaterial','base64','ngAnimate', 'ngMessages','ui.toggle','ngTable']);
app.config(function($routeProvider) {
	console.log("inside ngroute")
    $routeProvider
    .when("/", {
        templateUrl : "html/main.htm",
        controller  : 'mainController'
    }).when("/whoarewe", {
        templateUrl : "html/whoarewe.htm",
        controller  : 'whoareweController'
    }).when("/addDocs", {
        templateUrl : "html/addDocs.htm",
        controller  : 'addDocsController'
    })
     .when("/generalData", {
        templateUrl : "html/generalData.htm",
        controller  : 'generalDataController'
    })
    .when("/admin", {
        templateUrl : "html/admin.htm",
        controller  : 'adminController'
    });
});

 