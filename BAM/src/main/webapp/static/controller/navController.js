
app.controller('navController', function($rootScope, SessionService, $scope, $location, $http) {


	$scope.$on('$routeChangeStart', function(next, current) {
		SessionService.set("gotSubtopics", false);
		var somePath = $location.path();

		if (SessionService.get("currentUser").role < 2) {
			if (somePath == "/batchesAll" || somePath == "/batchesFuture"
					|| somePath == "/batchesPast" || somePath == "/register"
					|| somePath == "/associates" || somePath == "/editBatch") {
				$location.path('/home');
			}
		}
	});
	
//	$scope.hideNav = function (){
//		delete $rootScope.user;
//	}
	
	
	$scope.redirect = function (){
		SessionService.set("gotSubtopics", false);
		if(!SessionService.get("currentUser")){
			$location.path('/');
		}
	}
	
	$scope.redirect();
	
//	$scope.hideNav = function (){
//        delete $rootScope.user;
//    }
});