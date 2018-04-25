var app = angular.module("resiliencia", ["ngRoute"]);
app.config(function($routeProvider) {
	console.log("inside ngroute")
    $routeProvider
    .when("/", {
        templateUrl : "html/login.htm",
        controller  : 'loginController'
    })
    .when("/main", {
        templateUrl : "html/main.htm",
        controller  : 'mainController'

    })
    .when("/register", {
        templateUrl : "html/register.htm",
        controller  : 'mainController'
    })
    .when("/blue", {
        templateUrl : "blue.htm"
    });
});