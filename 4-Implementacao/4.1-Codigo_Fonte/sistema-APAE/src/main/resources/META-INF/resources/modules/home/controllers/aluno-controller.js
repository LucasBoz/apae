/**
 * Created by lucas on 11/06/2016.
 */
(function (angular) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('AlunoController', function ($rootScope, $scope, $state, $importService, $mdDialog, $mdSidenav) {

            $importService("alunoService");

            /*-------------------------------------------------------------------
             *                          ATTRIBUTES
             *-------------------------------------------------------------------*/
            /**
             * STATES
             * @type {{DETAIL: string, NEW: string, LIST: string}}
             */
            $scope.state = {
                DETAIL : "aluno.detail",
                NEW : "aluno.new",
                LIST : "aluno.list"
            };

            $scope.alunos = [];

            $scope.aluno = {
                familiares: [],
                irmaos: []
            };


            /**
             *
             */
            $scope.model = {


                query: {
                    filter: {
                        name: null,
                        status: ""
                    }
                },

                pageRequest: {//PageImpl
                    content: null,
                    pageable: {//PageRequest
                        page: 1,
                        size: 15,
                        sort: {
                            direction: 'ASC', properties: ['id']
                        }
                    }
                }
            };


            /*-------------------------------------------------------------------
             *                            HANDLERS
             *-------------------------------------------------------------------*/


            $scope.listTipoFamiliar = function () {

                alunoService.listTipoFamiliar({
                    callback: function (result) {

                        $scope.model.tipoResponsavel = result;

                    }, errorHandler: function (message, exception) {
                        $rootScope.toast(message);
                    }
                });

            };


            $scope.listAlunos = function () {
                alunoService.listAlunosByFilters(null, null, {
                    callback: function (result) {

                        $scope.model.pageRequest.content = result.content;

                        if (!$scope.model.pageRequest.content.length) {
                            $rootScope.toast("Nenhum aluno encontrado");
                        }

                    }, errorHandler: function (message, exception) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.findAlunoById = function ( id ) {
                alunoService.findAlunoById( id, {
                    callback: function (result) {
                        $scope.aluno = result;
                    }, errorHandler: function (message, exception) {
                        $rootScope.toast(message);
                    }
                })
            };


            $scope.removeFamiliar = function (familiar) {

                var idx = $scope.aluno.familiares.indexOf(familiar);
                $scope.aluno.familiares.splice(idx, 1);

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

                    alunoService.removeAluno(aluno.id, {
                        callback: function (result) {

                            $rootScope.toast("Aluno removido com sucesso");

                            $scope.model.pageRequest.content.splice($scope.model.pageRequest.content.indexOf($scope.aluno), 1);


                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);

                        }
                    })

                });
            };

            /**
             * DIALOG
             *
             */
            $scope.irmaoDialog = function (ev, irmao) {

                $mdDialog.show({
                    controller: IrmaoDialogController,
                    templateUrl: 'modules/home/views/aluno/irmao-dialog/irmao-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true,
                    locals: {
                        irmao: angular.copy(irmao),
                        popupConfig: {
                            title: irmao ? "Editar irmao" : "Nova irmao"
                        }
                    }
                })
                    .then(function (result) {

                        if (irmao) {
                            //editou
                            $scope.aluno.irmaos[$scope.aluno.irmaos.indexOf(irmao)] = result;

                        } else {
                            $scope.aluno.irmaos.push(result);
                        }
                    });

            };

            function IrmaoDialogController($scope, $mdDialog, irmao, popupConfig) {

                $scope.irmao = irmao;
                $scope.popupConfig = popupConfig;


                $scope.cancel = function () {
                    $mdDialog.cancel();
                };

                $scope.answer = function (irmao) {
                    $mdDialog.hide(irmao)
                };

            }


            /**
             * RESPONSAVEL
             *
             */
            $scope.responsavelListDialog = function (ev) {

                $mdDialog.show({
                    controller: responsavelListDialogController,
                    templateUrl: 'modules/home/views/aluno/responsavel-dialog/responsavel-list-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true,
                    locals: {}

                })
                    .then(function (result) {

                        if (result) {
                            $scope.aluno.familiares.push( {
                                responsavel : result
                            } );
                        }

                    });

            };

            $scope.showFamiliares = function (ev) {

                $mdDialog.show({
                    controller: familiarDialogController,
                    templateUrl: 'modules/home/views/aluno/responsavel-dialog/responsavel-list-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true
                })
            };


            function responsavelListDialogController($scope, $mdDialog) {

                $importService("responsavelService");

                responsavelService.listResponsavelByFilters(null, null, {
                    callback: function (result) {
                        $scope.responsaveis = result.content;
                    }, errorHandler: function (message, exception) {
                        $rootScope.toast(message);
                    }
                });

                $scope.selectResponsavel = function (responsavel) {
                    $scope.answer(responsavel);
                };

                $scope.cancel = function () {
                    $mdDialog.cancel();
                };

                $scope.answer = function (responsavel) {
                    $mdDialog.hide(responsavel)
                };

            }




            $scope.responsavelDialog = function (ev, familiar) {

                $mdDialog.show({
                    controller: ResponsavelDialogController,
                    templateUrl: 'modules/home/views/responsavel/responsavel-dialog/responsavel-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true,
                    locals: {responsavel: familiar ? angular.copy(familiar.responsavel) : null}

                })
                    .then(function (result) {

                        if(result){

                            var idx = $scope.aluno.familiares.indexOf(familiar);

                            if( idx > -1 ){

                                //editou
                                $scope.aluno.familiares[idx].responsavel = result;

                            } else {
                                //Novo dado
                                $scope.aluno.familiares.push(  { responsavel : result }  );

                            }
                        }

                    });

            };

            $scope.save = function (aluno) {

                if (!aluno.id) {

                    alunoService.insertAluno(aluno, {
                        callback: function (result) {

                            $rootScope.toast("Aluno inserido com sucesso");

                            $state.go("aluno.list");

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                } else {
                    alunoService.updateAluno(aluno, {
                        callback: function (result) {


                            $rootScope.toast("Aluno atualizado com sucesso");
                            $state.go("aluno.list");
                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                }

            };


            /**
             *
             * STATES
             */
            $scope.changeToEdit = function ( id ) {

                $scope.findAlunoById( id  );

                $scope.listTipoFamiliar();

            };

            $scope.changeToList = function () {

                $scope.listAlunos();

            };

            $scope.changeToNew = function () {
                console.log("NOVOPOOO");
            };

            $scope.$on('$stateChangeSuccess', function() {

                switch( $state.current.name ){
                    case $scope.state.LIST :
                        $scope.changeToList();
                        break;
                    case $scope.state.DETAIL :
                        $scope.changeToEdit( $state.params.id );
                        break;
                    case $scope.state.NEW :
                        $scope.changeToNew ();
                        break;
                }

            });



        });

}(window.angular));