var UserService = angular.module('UserService', [])
UserService.factory('UserDataOp', ['$http', 'baseUrl', function ($http, baseUrl) {
	var urlBase = baseUrl + '/auth';
	var UserDataOp = {};
	
	UserDataOp.addUser = function (user) {
		return $http.post(urlBase + '/register', user);
	};
	return UserDataOp;
}]);