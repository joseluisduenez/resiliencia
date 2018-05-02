var app = angular.module("resiliencia", ["ngRoute",'ngMaterial','base64']);
app.config(function($routeProvider) {
	console.log("inside ngroute")
    $routeProvider
    .when("/", {
        templateUrl : "html/login.htm",
        controller  : 'loginController'
    })
    
    .when("/register", {
        templateUrl : "html/register.htm",
        controller  : 'registerController'
    });
});