/**
 * Created by lucas on 11/06/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('AlunoController', function( $rootScope, $scope, $state, $importService, $mdDialog, $mdSidenav ) {

            $importService("alunoService");
        
            /*-------------------------------------------------------------------
             *                          ATTRIBUTES
             *-------------------------------------------------------------------*/


            $scope.alunos = [];

            

            /**
             *
             */
            $scope.model = {


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


            /*-------------------------------------------------------------------
             *                            HANDLERS
             *-------------------------------------------------------------------*/


            $scope.listAlunos = function () {
                alunoService.listAlunosByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum aluno encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.changeToDetail = function ( aluno ) {
                alunoService.findAlunoById ( aluno.id, {
                    callback: function ( result ) {
                        $scope.aluno = result;
                        $state.go( "aluno.new" );
                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.removeAluno = function (ev, aluno) {

                $scope.aluno = aluno;

                var confirm = $mdDialog.confirm()
                    .title('Excluir aluno')
                    .content("Você realmente deseja excluir o aluno " + aluno.nome + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    alunoService.removeAluno ( aluno.id, {
                        callback: function ( result ) {

                            $rootScope.toast("Aluno removido com sucesso");

                            $scope.model.pageRequest.content.splice(  $scope.model.pageRequest.content.indexOf(  $scope.aluno ), 1 );


                        }, errorHandler: function ( message, exception ) {
                            $rootScope.toast(message);

                        }
                    })

                });
            };
            


            $scope.save = function( aluno ){

                if (!aluno.id) {

                    alunoService.insertAluno(aluno, {
                        callback: function (result) {

                            $rootScope.toast("Aluno inserido com sucesso");
                            
                            $state.go( "aluno.list" );

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                } else {
                    alunoService.updateAluno(aluno, {
                        callback: function (result) {


                            $rootScope.toast("Aluno atualizado com sucesso");
                            $state.go( "aluno.list" );
                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                }

            };

            $scope.listAlunos();


        });

}(window.angular));