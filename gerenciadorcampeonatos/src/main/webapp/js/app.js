'use strict';

// Declare app level module which depends on filters, and services
angular
    .module('ngdemo', [
            'ngdemo.rodapeDirective',
            'restangular'])
       
   .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/dummy', {templateUrl: 'views/main.html', controller: 'HeaderController'});
        $routeProvider.when('/times', {templateUrl: 'views/times.html', controller: 'ControllerTime'});
        $routeProvider.when('/patrocinadores', {templateUrl: 'views/patrocinadores.html', controller: 'ControllerPatrocinador'});
        $routeProvider.otherwise({redirectTo: '/dummy'});
    }])
        
    .config(function(RestangularProvider) {

		var newBaseUrl = "";
		if (window.location.hostname == "localhost") {
			newBaseUrl = "http://localhost:8080/app/api/";
		} else {
			var deployedAt = window.location.href.substring(0, window.location.href);
			newBaseUrl = deployedAt + "/api/";
		}
		RestangularProvider.setBaseUrl(newBaseUrl);
    });
    


