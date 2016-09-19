/**
 * Created by lucas on 02/07/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('ResponsavelController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog ) {

            $importService("responsavelService");

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

            $scope.model.pageRequest.content = [
                {
                    
                }
            ];


            $scope.listResponsaveis = function () {
                responsavelService.listResponsavelByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum responsável encontrado");
                        }
                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.removeResponsavel = function (ev, responsavel) {

                var confirm = $mdDialog.confirm()
                    .title('Excluir responsável')
                    .content("Você realmente deseja excluir o responsável " + responsavel.nome + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    responsavelService.removeResponsavel ( responsavel.id, {
                        callback: function ( result ) {

                            $rootScope.toast("Responsável removido com sucesso");

                            $scope.model.pageRequest.content.splice(  $scope.model.pageRequest.content.indexOf(responsavel), 1 );


                        }, errorHandler: function ( message, exception ) {
                            $rootScope.toast(message);

                        }
                    })

                });



            };

            $scope.changeToEdit = function (ev, responsavel) {
                
                $mdDialog.show({
                        controller: ResponsavelDialogController,
                        templateUrl: 'modules/home/views/responsavel/responsavel-dialog/responsavel-dialog.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose:true,
                        locals: {responsavel: angular.copy(responsavel)}
                    })
                    .then(function(answer) {

                        var idx = $scope.model.pageRequest.content.indexOf(responsavel);

                        if( idx > -1 ){

                            //editou
                            $scope.model.pageRequest.content[idx] = answer;

                        } else {
                            //Novo dado
                            $scope.model.pageRequest.content.unshift( answer );

                        }

                    });
          
            };

            function ResponsavelDialogController($scope, $mdDialog, responsavel) {

                $scope.responsavel = responsavel;

                if(!$scope.responsavel){
                    $scope.responsavel = {telefones : []};
                }

                $scope.save = function( responsavel ){

                    if (!responsavel.id) {

                        responsavelService.insertResponsavel(responsavel, {
                            callback: function (result) {

                                $rootScope.toast("Responsável inserido com sucesso");

                                $mdDialog.hide(result);

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    } else {
                        responsavelService.updateResponsavel(responsavel, {
                            callback: function (result) {

                                $rootScope.toast("Responsável atualizado com sucesso");

                                $mdDialog.hide(result);

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    }

                };

                $scope.removeTelefone = function(telefone){

                    var idx = $scope.responsavel.telefones.indexOf(telefone);
                    $scope.responsavel.telefones[idx] = { numero : 'deletado', tipo : 'tambem' }

                };

                $scope.hide = function() {
                    $mdDialog.hide();
                };
                $scope.cancel = function() {
                    $mdDialog.cancel();
                };
                $scope.answer = function( responsavel ) {
                    $scope.save(responsavel);
                };


            }

            //


            $scope.listResponsaveis();

        });

}(window.angular));
