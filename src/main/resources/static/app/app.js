var app = angular.module('paladin', [
                                     'ui.router',
                                     'ngStorage',
                                     'UserService'
                                     ]);

app.constant('baseUrl', 'http://www.joinpaladin.com');
//app.constant('baseUrl', 'http://localhost:8080');


app.run(['$rootScope', '$location','$localStorage', '$state', function($rootScope, $location, $localStorage, $state) {
	$rootScope.$on('$stateChangeSuccess', function() {
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	});
	$rootScope.$on("$stateChangeStart", function(event, toState, toParams, fromState, fromParams, options){
		if (toState.authorize === true) {
			toState.resolve = toState.resolve || {};
			if (typeof $localStorage.token == "undefined") {
				event.preventDefault();
				$state.go('login');
			}
		}
	});
}]);

app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$httpProvider', function ($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {
	$stateProvider
	.state('home', {url: '/', templateUrl: '/partials/home.html'})	    
	.state('lawyers', {url: "/lawyers", templateUrl: '/partials/lawyer_info.html'})
	.state('enterprises', {url: '/enterprises', templateUrl: "/partials/enterprise_info.html"})
	.state('nonprofits', {url: '/nonprofits', templateUrl: '/partials/nonprofit_info.html'})
	.state('schools', {url: '/schools', templateUrl: '/partials/school_info.html'})
	.state('team', {url: '/team', templateUrl: '/partials/team-info.html'})
	.state('terms', {url: '/terms', templateUrl: '/partials/terms.html'})
	.state('faq', {url: '/faq', templateUrl: '/partials/faq.html'})
	.state('privacypolicy', {url: '/privacypolicy', templateUrl: '/partials/privacy-policy.html'})
	.state('signup', {
		url: '/signup',
		templateUrl: '/partials/signup.html',
		controller: 'signupController',
		abstract:true
	})
	.state('signup.userBase', {
		url: '',
		templateUrl: '/partials/signup-base.html'
	})
	.state('signup.lawyers', {
		url: '',
		templateUrl: '/partials/lawyer-profile-form.html'
	})
	.state('signup.students', {
		url: '',
		templateUrl: '/partials/student-profile-form.html'
	})
	.state('success', {
		url: '/success',
		templateUrl: '/partials/form-success.html'
	})
	.state('failure', {
		url: '/error',
		templateUrl: '/partials/form-error.html'
	})
	.state('reset-password', {
		url: '/resetPassword/:token',
		templateUrl: '/partials/reset-password.html',
		controller: 'ResetPasswordController',
		resolve: {
			data: ['$http', "$stateParams", 'baseUrl', function ($http, $stateParams, baseUrl) {
				return $http.post(baseUrl + '/auth/resetPassword/verify', $stateParams.token)
				.then(function(response){ 
					return response.data;
				}, 
				function(){ return null });
			}]
		},
	})
	.state('login', {
		url: '/login',
		templateUrl: '/partials/login.html',
		controller:'LoginController'
	})
	.state('admin-home', {
		url: '/admin',
		templateUrl: '/partials/admin-home.html',
		controller:'AdminController',
		authorize:true
	})
	.state('opportunity', {
		url: '/opportunity/:token',
		templateUrl: '/partials/opportunity-page.html',
		controller: 'OpportunityController',
		resolve: {
			data: ['$http', "$stateParams", 'baseUrl', function ($http, $stateParams, baseUrl) {
				return $http.post(baseUrl + '/opportunity/verify', $stateParams.token)
				.then(function(response){ 
					return response.data;
				}, 
				function(){ return null; });
			}]
		},
	})
	.state('enterpriseEnroll', {
		url: '/enterprises/:token/enroll',
		templateUrl: '/partials/enterprise-enroll.html',
		controller: 'EnterpriseEnrollController',
		resolve: {
			data: ['$http', "$stateParams", 'baseUrl', function ($http, $stateParams, baseUrl) {
				return $http.post(baseUrl + '/enterprises/get', $stateParams.token)
				.then(function(response){ 
					return response.data;
				}, 
				function(){ return null; });
			}]
		},
		abstract:true
	})
	.state('enterpriseEnroll.userBase', {
		url: '',
		templateUrl: '/partials/enterprise-enroll-base.html'
	})
	.state('enterpriseEnroll.lawyers', {
		url: '',
		templateUrl: '/partials/lawyer-profile-form.html'
	})
	.state('enterpriseEnroll.students', {
		url: '',
		templateUrl: '/partials/student-profile-form.html'
	});


	$urlRouterProvider.otherwise('/');

	//$locationProvider.html5Mode(true);

	$httpProvider.interceptors.push(['$localStorage', function ($localStorage) {
		return {
			'request': function (config) {
				config.headers = config.headers || {};
				if ($localStorage.token) {
					config.headers.Authorization = $localStorage.token;
				}
				return config;
			}
		};
	}]);
}]);

app.controller('signupController', ['$scope','$state','UserDataOp', '$http', 'baseUrl', function($scope, $state, UserDataOp, $http, baseUrl) {

	$http.get(baseUrl + '/auth/opportunityOptions')
	.then(function(response){ 
		$scope.opportunityOptions = response.data;
	});
	$http.get(baseUrl + '/auth/languageOptions')
	.then(function(response){ 
		$scope.languageOptions = response.data;
	});
	$http.get(baseUrl + '/auth/advocacyOptions')
	.then(function(response){ 
		$scope.advocacyOptions = response.data;
	});

	$scope.user = {};

	$scope.routeForm = function() {
		type = $scope.user.userType;
		if (type == "lawyer") {
			$state.go('signup.lawyers');
		}
		else if (type == "student") {
			$state.go('signup.students');
		}
		else {
			$scope.submitForm();
		}
	};

	$scope.submitForm = function() {
		UserDataOp.addUser($scope.user)
		.success(function () {
			$state.go('success');
		}).
		error(function (error) {
			$state.go('failure');
		});
	};

}]);

app.directive('dropdownMultiselect', function () {
	return {
		restrict: 'AE',
		scope: {
			options: '=',
			pre_selected: '=preSelected',
			dropdownTitle: '@',
			model: '=ngModel',
			key: '@'
		},
		template: "<div class='scrollable-menu-container'>" +
		"<ul class='scrollable-menu'>" +
		"<li>{{dropdownTitle}}<span class='pull-right'><input type='checkbox' data-ng-change='checkAllClicked()' data-ng-model=checkAll> Check All</span></li>" +
		"<hr>" +
		"<li data-ng-repeat='option in options'> <input type='checkbox' data-ng-change='setSelectedItem(option)' ng-model='selectedItems[option.name]'> {{option.displayName}}</li>" +
		"</ul></div>",
		controller: ['$scope', function ($scope) {
			$scope.selectedItems = {};
			$scope.checkAll = false;

			init();

			function init() {
				if (!$scope.model) {
					$scope.model = {}
				}
				key = $scope.key
				$scope.model[key] = [];
				if ($scope.pre_selected) {
					for (var i = 0; i < $scope.pre_selected.length; i++) {
						$scope.model[key].push($scope.pre_selected[i].name);
						$scope.selectedItems[$scope.pre_selected[i].name] = true;
					}
					if ($scope.pre_selected.length == $scope.options.length) {
						$scope.checkAll = true;
					}
				}
			}

			$scope.checkAllClicked = function () {
				if ($scope.checkAll) {
					selectAll();
				} else {
					deselectAll();
				}
			}

			function selectAll() {
				key = $scope.key
				$scope.model[key] = [];
				$scope.selectedItems = {};
				angular.forEach($scope.options, function (option) {
					$scope.selectedItems[option.name] = true;
					$scope.model[key].push(option);
				});
				angular.forEach($scope.model[key], function (name) {
					$scope.selectedItems[name] = true;
				});
			};

			function deselectAll() {
				key = $scope.key
				$scope.model[key] = [];
				$scope.selectedItems = {};
			};

			$scope.setSelectedItem = function (option) {
				key = $scope.key
				var filteredArray = [];
				if (!$scope.model[key]){
					$scope.model[key] = [];
				}
				if ($scope.selectedItems[option.name] == true) {
					$scope.model[key].push(option);
				} else {
					filteredArray = $.grep($scope.model[key], function(e){ 
						return e.name != option.name; 
					});
					$scope.model[key] = filteredArray;
					$scope.checkAll = false;
				}
				return false;
			};
		}]
	}
});

app.controller("headernav",['$scope', function($scope){
	$scope.expanded = false;
	$scope.toggleHeader = function(){
		$scope.expanded = $scope.expanded === false ? true: false;
	};
}]);


app.controller('ResetPasswordController',['$http','$scope', 'data','baseUrl', function($http, $scope, data, baseUrl) {
	$scope.data = data;
	$scope.$watch('confirmPassword',function(){
		if ($scope.password == $scope.confirmPassword) {
			$scope.error = false;
		}
		else {
			$scope.error = true
		}
	});
	$scope.processForm = function() {
		if ($scope.password == $scope.confirmPassword) {
			dto = {token: $scope.data.token, password: $scope.password}
			$http.post(baseUrl + '/auth/resetPassword/reset', dto)
			.then(function(response){ 
				$scope.success=true
			}, 
			function(){ return null });
		}
		else  {
			$scope.error = true;
		}
	};
}])

app.controller('LoginController',['$http','$scope', '$localStorage', '$state', 'baseUrl', function($http, $scope, $localStorage, $state, baseUrl) {
	$scope.processForm = function() {
		dto = {email: $scope.email, password: $scope.password}
		$http.post(baseUrl + '/auth/login', dto)
		.then(function(response){ 
			$localStorage.token = response.data.token;
			$state.go('admin-home');
		}, 
		function(){ $scope.error = true; });
	};
}])

app.controller('AdminController',['$http','$scope', '$state', 'baseUrl', function($http, $scope, $state, baseUrl) {

	$scope.formData = {};
	$scope.nonprofitData = {};

	$http.get(baseUrl + '/auth/opportunityOptions')
	.then(function(response){ 
		$scope.opportunityOptions = response.data;
	});
	$http.get(baseUrl + '/auth/languageOptions')
	.then(function(response){ 
		$scope.languageOptions = response.data;
	});
	$http.get(baseUrl + '/auth/advocacyOptions')
	.then(function(response){ 
		$scope.advocacyOptions = response.data;
	});
	$http.get(baseUrl + '/api/nonprofits/all')
	.then(function(response){ 
		$scope.nonprofits = response.data;
	});


	$scope.submitOpportunity = function() {
		$http.post(baseUrl + '/api/opportunity/submit', $scope.formData)
		.then(function(response){ 
			$state.go($state.current, {}, {reload: true});
		}, 
		function(){ $scope.error = true; });

	};

	$scope.submitNonprofit = function() {
		$http.post(baseUrl + '/api/nonprofit/submit', $scope.nonprofitData)
		.then(function(response){ 
			$state.go($state.current, {}, {reload: true});
		}, 
		function(){ $scope.error = true; });

	};

	$scope.submitEnterprise = function() {
		$http.post(baseUrl + '/api/enterprise/submit', $scope.enterpriseData)
		.then(function(response){ 
			$state.go($state.current, {}, {reload: true});
		}, 
		function(){ $scope.error = true; });

	};
}]);

app.controller('opportunitySelectController', ['$http', '$scope', '$state', 'baseUrl', function($http, $scope, $state, baseUrl) {
	$scope.sortType     = 'name'; // set the default sort type
	$scope.sortReverse  = false;  // set the default sort order
	$scope.searchTerm   = '';     // set the default search/filter term

	$http.get(baseUrl + '/api/opportunities/all')
	.then(function(response) { 
		$scope.opportunities = response.data;
	});


	$http.get(baseUrl + '/api/users/all')
	.then(function(response) { 
		$scope.users = response.data;
	});

	$http.get(baseUrl + '/api/nonprofits/all')
	.then(function(response){ 
		$scope.nonprofits = response.data;
	});

	$http.get(baseUrl + '/api/enterprises/all')
	.then(function(response){ 
		$scope.enterprises = response.data;
	});

	$scope.selectedItems = {};

	$scope.matchEmail = {}

	$scope.setSelectedItem = function (option) {
		if (!$scope.matchEmail.opportunities) {
			$scope.matchEmail.opportunities = [];
		}
		var filteredArray = [];
		if ($scope.selectedItems[option.id] == true) {
			$scope.matchEmail.opportunities.push(option);
		} else {
			filteredArray = $.grep($scope.matchEmail.opportunities, function(e){ 
				return e.id != option.id; 
			});
			$scope.chosenOpps = filteredArray;
		}
		return false;
	};

	$scope.sendMatchEmail = function() {
		$http.post(baseUrl + '/api/users/sendMatchEmail', $scope.matchEmail)
		.then(function(response){ 
			$state.go($state.current, {}, {reload: true});
		}, 
		function(){ $scope.error = true; });
	}

	$scope.pairUserAndOpportunity = function() {
		$http.post(baseUrl + '/api/users/pairOpportunity', $scope.opportunitySelect)
		.then(function(response){ 
			$state.go($state.current, {}, {reload: true});
		}, 
		function(){ $scope.error = true; });
	}


}]);


app.controller('OpportunityController', ['$http', '$scope', '$state', 'data', 'baseUrl', function($http, $scope, $state, data, baseUrl) {
	if (data) {
		$scope.opportunity = data.opportunity;
	}
	$scope.selectOpportunity = function() {
		$http.post(baseUrl + '/opportunity/select', data.token)
		.then(function(response){ 
			$scope.success=true
		}, 
		function(){ $scope.error = true });
	}
}]);

app.controller('EnterpriseEnrollController', ['$http', '$scope', '$state', 'data', 'baseUrl', 'UserDataOp', function($http, $scope, $state, data, baseUrl, UserDataOp) {
	$scope.user = {};
	if (data) {
		$scope.user.organization = data;
		$scope.success = true;
	}

	$http.get(baseUrl + '/auth/opportunityOptions')
	.then(function(response){ 
		$scope.opportunityOptions = response.data;
	});
	$http.get(baseUrl + '/auth/languageOptions')
	.then(function(response){ 
		$scope.languageOptions = response.data;
	});
	$http.get(baseUrl + '/auth/advocacyOptions')
	.then(function(response){ 
		$scope.advocacyOptions = response.data;
	});



	$scope.processForm = function() {
		UserDataOp.addUser($scope.user)
		.success(function () {
			$state.go('success');
		}).
		error(function (error) {
			$state.go('failure');
		});
	};

	$scope.routeForm = function() {
		type = $scope.user.organization.formType;
		if (type == "students") {
			$scope.user.userType = "student";
			$state.go('enterpriseEnroll.students');
		}
		else {
			$scope.user.userType = "lawyer";
			$state.go('enterpriseEnroll.lawyers');
		}
	};
}]);
