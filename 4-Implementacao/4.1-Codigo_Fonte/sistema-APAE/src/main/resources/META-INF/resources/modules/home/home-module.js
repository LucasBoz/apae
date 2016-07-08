(function(window, angular, undefined) {
	'use strict';

	//Start the AngularJS
	var module = angular.module('home', ['ngMessages', 'ngSanitize', 'ngMaterial', 'ui.router', 'eits-md', 'eits-ng' ]);

	/**
	 * 
	 */
	module.config( function( $stateProvider, $urlRouterProvider, $importServiceProvider, $translateProvider ) {
		//-------
		//Broker configuration
		//-------
		$importServiceProvider.setBrokerURL("./broker/interface");
		//-------
		//Translate configuration
		//-------
		$translateProvider.useURL('./bundles');

		//-------
		//URL Router
		//-------
        $urlRouterProvider.otherwise("/");

		//HOME
		$stateProvider.state('home', {
			url: "/",
			templateUrl: './modules/home/views/home/home-index.html'
		})
		.state('aluno', {
			url: "/aluno",
			templateUrl: './modules/home/views/aluno/aluno-index.html',
			controller: 'AlunoController',
			abstract: true
		})
		.state('aluno.list', {
			url: "/lista",
			templateUrl: './modules/home/views/aluno/aluno-list.html'
		})
		.state('aluno.detail', {
			url: "/detalhe/{id:[0-9]{1,10}}",
			templateUrl: './modules/home/views/aluno/aluno-detail.html'
		})
		.state('aluno.new', {
			url: "/novo",
			templateUrl: './modules/home/views/aluno/aluno-new.html'
		})
		.state('aluno.edit', {
			url: "/editar/{id:[0-9]{1,10}}",
			templateUrl: './modules/home/views/aluno/aluno-edit.html'
		})
		.state('responsavel', {
			url: "/",
			templateUrl: './modules/home/views/responsavel/responsavel-index.html',
			controller: 'ResponsavelController',
			abstract: true
		})
		.state('responsavel.list', {
			url: "responsavel",
			templateUrl: './modules/home/views/responsavel/responsavel-list.html'
		});
	});

	/**
	 * 
	 */
	module.run( function( $rootScope, $window, $state, $stateParams ) {
		//$rootScope.$usuario 	= $window.usuario;
		$rootScope.$state 		= $state;
		$rootScope.$stateParams = $stateParams;
	});

	/**
	 * 
	 */
	angular.element(document).ready( function() {
		angular.bootstrap( document, ['home']);
	});

})(window, window.angular);