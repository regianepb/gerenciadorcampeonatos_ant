'use strict';

// Declare app level module which depends on filters, and services
angular
    .module('ngdemo', [
            'ngdemo.ctrlUsuario',
            'ngdemo.rodapeDirective',
            'restangular'])
       
   .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/dummy', {templateUrl: 'views/main.html', controller: 'HeaderController'});
        $routeProvider.when('/entidades', {templateUrl: 'views/entidades.html', controller: 'ControllerEntidade'});
        $routeProvider.when('/usuarios', {templateUrl: 'views/usuarios.html', controller: 'ControllerUsuario'});
        $routeProvider.when('/cargos', {templateUrl: 'views/cargos.html', controller: 'ControllerCargo'});
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
    


