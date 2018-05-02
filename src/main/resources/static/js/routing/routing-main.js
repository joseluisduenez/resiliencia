var app = angular.module("resiliencia-main", ["ngRoute",'ngMaterial','base64','ngAnimate', 'ngMessages']);
app.config(function($routeProvider) {
	console.log("inside ngroute")
    $routeProvider
    .when("/", {
        templateUrl : "html/main.htm",
        controller  : 'mainController'
    })
    
    .when("/admin", {
        templateUrl : "html/admin.htm",
        controller  : 'adminController'
    });
});