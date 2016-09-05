/**
 * Created by lucas on 04/09/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('FuncionarioController', function ($rootScope, $scope, $state, $importService, $mdToast, $mdDialog) {

            $importService("funcionarioService");


        });
});

