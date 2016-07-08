/**
 * Created by lucas on 11/06/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */''
    angular.module('home')
        .controller('AlunoController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog, $mdSidenav ) {

            $importService("alunoService");
        
            /*-------------------------------------------------------------------
             *                          ATTRIBUTES
             *-------------------------------------------------------------------*/

            $scope.NOVO_HOSPEDE_STATE        = "hospede.novo";
            $scope.EDITAR_HOSPEDE_STATE      = "hospede.editar";
            $scope.DETALHE_HOSPEDE_STATE   	 = "hospede.detalhe";
            $scope.LISTA_HOSPEDE_STATE     	 = "hospede.lista";

            $scope.teste = "fndsçojifposá";

            $scope.alunos = [];

            

            /**
             *
             */
            $scope.model = {

                hospede : {

                },

                query : {
                    filter  : {name : null,
                        status : ""
                    }
                },

                pageRequest : {//PageImpl
                    content : null,
                    pageable : {//PageRequest
                        page : 1,
                        size : 15,
                        sort : {
                            direction: 'ASC', properties: ['id']
                        }
                    }
                }
            };

            /**
             *
             */
            $scope.$watch( "[model.pageRequest.pageable.size, model.pageRequest.pageable.page]" , function( value, oldValue ){
                if( $scope.model.pageRequest.content ) {
                    $scope.listUsersByFilters ( $scope.model.query.filter.name, $scope.model.query.filter.status);
                }
            }, true);

            /*-------------------------------------------------------------------
             *                            HANDLERS
             *-------------------------------------------------------------------*/

            /**
             *
             * @param event,
             * @param toState,
             * @param toParams,
             * @param fromState,
             * @param fromParams
             */
            $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {

                $scope.model.hospede = {

                };

                switch( toState.name ){
                    case $scope.LISTA_HOSPEDE_STATE :
                        $scope.listHospedesByFilters( null, null );
                        break;
                    case $scope.EDITAR_HOSPEDE_STATE :
                        $scope.findHospedeById( toParams.id );
                        break;
                    case $scope.DETALHE_HOSPEDE_STATE :
                        $scope.findHospedeById ( toParams.id );
                        break;
                }

            });


            $scope.changeToEdit = function( ev, hospede ) {
                $state.go( $scope.EDITAR_HOSPEDE_STATE, {id: hospede.id} );
            };


            $scope.changeToDetail = function( ev, hospede ) {
                var tagName = ev.target.tagName.toLowerCase();
                if ( tagName != "button" && tagName != "md-icon" ) {
                    $state.go( $scope.DETALHE_HOSPEDE_STATE, {id: hospede.id} );
                }
            };

            $scope.listAlunos = function () {
                alunoService.listAlunosByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.alunos = result.content;

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast("edsfwqsdfv", "red");
                        document.getElementById("email").focus();
                    }
                })
            };

            $scope.changeToDetail = function ( id ) {
                alunoService.findAlunoById ( id, {
                    callback: function ( result ) {
                        $scope.aluno = result;
                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast("edsfwqsdfv", "red");
                        document.getElementById("email").focus();
                    }
                })
            };
            


            $scope.save = function( aluno ){

                if (!aluno.id) {

                    alunoService.insertAluno(aluno, {
                        callback: function (result) {

                            $rootScope.toast("user.SaveUserSuccess", "green");
                            $state.go($scope.LIST_USER_STATE);
                            $scope.$apply();

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast($translate("emailUniqueViolation"), "red");
                        }
                    })
                } else {
                    alunoService.update(aluno, {
                        callback: function (result) {

                            $rootScope.toast("user.SaveUserSuccess", "green");
                            $state.go($scope.LIST_USER_STATE);
                            $scope.$apply();

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast($translate("emailUniqueViolation"), "red");
                            document.getElementById("email").focus();
                        }
                    })
                }

            };


            $scope.onOrderChange = function (order) {
                if ( order[0] == "-" ) {
                    order = order.replace("-","");
                    $scope.model.pageRequest.pageable.sort.direction = "DESC";
                } else {
                    $scope.model.pageRequest.pageable.sort.direction = "ASC";
                }

                $scope.model.pageRequest.pageable.sort.properties[0] = order;
                $scope.listUsersByFilters ( $scope.model.query.filter.name, $scope.model.query.filter.status );
            };


            $scope.onPaginationChange = function (page, limit) {
                $scope.model.pageRequest.pageable.page = page ;
                $scope.model.pageRequest.pageable.size = limit;
            };

        });

}(window.angular));