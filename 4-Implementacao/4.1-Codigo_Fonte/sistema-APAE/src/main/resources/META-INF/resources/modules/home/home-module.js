(function(window, angular, undefined) {
	'use strict';

	//Start the AngularJS
	var module = angular.module('home', ['ngMessages', 'ngSanitize', 'ngMaterial', 'ui.router', 'eits-md', 'md.data.table', 'eits-ng' ]);

	/**
	 * 
	 */
	module.config(
		function( $stateProvider, $urlRouterProvider, $importServiceProvider, $translateProvider, $mdThemingProvider, $mdDateLocaleProvider ) {

		/**
		 * MOMENT
		 */
		$mdDateLocaleProvider.formatDate = function(date) {
			var m = moment(date);
			return m.isValid() ? m.format('L') : '';
		};


		/**
		 *  HOME
		 */
		$stateProvider.state('home', {
			url: "/",
			templateUrl: './modules/home/views/home/home-index.html'
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
		})

		/**
		 * Area de atendimento
		 */
		.state('areaAtendimento', {
			url: "/",
			templateUrl: './modules/home/views/areaAtendimento/areaAtendimento-index.html',
			controller: 'AreaAtendimentoController',
			abstract: true
		})
		.state('areaAtendimento.list', {
			url: "areaAtendimento",
			templateUrl: './modules/home/views/areaAtendimento/areaAtendimento-list.html'
		});


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
        $urlRouterProvider.otherwise("/aluno/lista");


		/**
		 * THEME
		 */

		var customPrimary = {
			'50': '#E8F5E9',
			'100': '#C8E6C9',
			'200': '#A5D6A7',
			'300': '#81C784',
			'400': '#66BB6A',
			'500': '#4CAF50',
			'600': '#43A047',
			'700': '#00923f', // default system color
			'800': '#2E7D32',
			'900': '#1B5E20',
			'A100': '#B9F6CA',
			'A200': '#69F0AE',
			'A400': '#00E676',
			'A700': '#00C853',
			'contrastDefaultColor': 'light'
		};


		var customAccent = {

			'50': '#FBE9E7',
			'100': '#FFCCBC',
			'200': '#FFAB91',
			'300': '#FF8A65',
			'400': '#FF7043',
			'500': '#FF5722', // Fab button color
			'600': '#F4511E',
			'700': '#E64A19',
			'800': '#D84315',
			'900': '#BF360C',
			'A100': '#FF9E80',
			'A200': '#FF6E40',
			'A400': '#FF3D00',
			'A700': '#FFFF00' // Fab button color hover
		};

		var customBackground = {
			'50': '#ffffff', // Button color
			'100': '#ff6400',
			'200': '#003d31',
			'300': '#388E3C', // Header and Selection DatePicker
			'400': '#666666',
			'500': 'f1f1f1',  // background Color
			'600': '#e65a00',
			'700': '#cc5000',
			'800': '#b34600',
			'900': '#000000',  // background Dialog
			'A100': '#ffffff', // background DatePicker
			'A200': '#000000', // Text color DatePicker
			'A400': '#00896f',
			'A700': '#23ffd4'
		};

		$mdThemingProvider.definePalette('customPrimary', customPrimary);
		$mdThemingProvider.definePalette('customAccent', customAccent);
		$mdThemingProvider.definePalette('customBackground', customBackground);


		$mdThemingProvider.theme('default')
			.primaryPalette('customPrimary', {
				'default': '700'
			}).accentPalette('customAccent', {
				'default': '500'
			}).backgroundPalette('customBackground', {
				'default': '500'
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