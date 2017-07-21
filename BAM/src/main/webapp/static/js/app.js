var app = angular.module('bam', ['ngRoute']);
app.config(function($routeProvider, $locationProvider){
	$locationProvider.html5Mode(false).hashPrefix('');
	$routeProvider.when("/",{
		templateUrl: "static/pages/login.html",
		controller: 'loginCtl'
	}).when("/allbatches",{
		templateUrl:"static/pages/allbatches.html"
	}).when("/register",{
		templateUrl: "static/pages/register.html"
	}).otherwise({redirectTo: '/'})
});