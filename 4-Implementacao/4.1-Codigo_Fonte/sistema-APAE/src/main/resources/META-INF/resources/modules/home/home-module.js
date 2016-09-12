(function(window, angular, undefined) {
	'use strict';

	//Start the AngularJS
	var module = angular.module('home', ['ngMessages', 'ngSanitize', 'ngMaterial', 'ui.router', 'eits-md', 'eits-ng' ]);

	/**
	 * 
	 */
	module.config( function( $stateProvider, $urlRouterProvider, $importServiceProvider, $translateProvider, $mdThemingProvider ) {
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

		/**
		 *  HOME
		 */
		$stateProvider.state('home', {
			url: "/aluno",
			templateUrl: './modules/home/views/aluno/aluno-index.html',
			controller: 'AlunoController',
			abstract: true

			// url: "/",
			// templateUrl: './modules/home/views/home/home-index.html'
		})
		/**
		 * ALUNO
		 */
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
			
		/**
		 * CID
		 */
		.state('cid', {
			url: "/",
			templateUrl: './modules/home/views/cid/cid-index.html',
			controller: 'CidController',
			abstract: true
		})
		.state('cid.list', {
			url: "cid",
			templateUrl: './modules/home/views/cid/cid-list.html'
		})
			
		/**
		 * RESPONSAVEL
		 */
		.state('responsavel', {
			url: "/",
			templateUrl: './modules/home/views/responsavel/responsavel-index.html',
			controller: 'ResponsavelController',
			abstract: true
		})
		.state('responsavel.list', {
			url: "responsavel",
			templateUrl: './modules/home/views/responsavel/responsavel-list.html'
		})

		/**
		 * TRANSPORTE
		 */
		.state('transporte', {
			url: "/",
			templateUrl: './modules/home/views/transporte/transporte-index.html',
			controller: 'TransporteController',
			abstract: true
		})
		.state('transporte.list', {
			url: "transporte",
			templateUrl: './modules/home/views/transporte/transporte-list.html'
		})

		/**
		 * USUÁRIOS
		 */
		.state('usuario', {
			url: "/",
			templateUrl: './modules/home/views/usuario/usuario-index.html',
			controller: 'UserController',
			abstract: true
		})
		.state('usuario.list', {
			url: "usuario",
			templateUrl: './modules/home/views/usuario/usuario-list.html'
		})

		/**
		 * FUNCIONARIO
		 */
		.state('funcionario', {
			url: "/funcionario",
			templateUrl: './modules/home/views/funcionario/funcionario-index.html',
			controller: 'FuncionarioController',
			abstract: true
		})
		.state('funcionario.list', {
			url: "/funcionarios",
			templateUrl: './modules/home/views/funcionario/funcionario-list.html'
		})
		.state('funcionario.detail', {
			url: "/detalhe/{id:[0-9]{1,10}}",
			templateUrl: './modules/home/views/funcionario/funcionario-detail.html'
		})
		.state('funcionario.new', {
			url: "/novo",
			templateUrl: './modules/home/views/funcionario/funcionario-new.html'
		})
		.state('funcionario.edit', {
			url: "/editar/{id:[0-9]{1,10}}",
			templateUrl: './modules/home/views/funcionario/funcionario-edit.html'
		});



		$mdThemingProvider.theme('default')
			.primaryPalette('light-green', {
				'default': '700'
			}).accentPalette('yellow', {
			'default': '900'
		}).backgroundPalette('blue-grey', {
			'default': 'A100'
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