/**
 * Created by lucas on 02/07/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('AreaAtendimentoController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog ) {

            $importService("areaAtendimentoService");

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


            $scope.listAreaAtendimento = function () {
                areaAtendimentoService.listAreaAtendimentosByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhuma área de atendimento encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);

                    }
                })
            };

            $scope.remove = function (ev, areaAtendimento) {

                var confirm = $mdDialog.confirm()
                    .title('Excluir areaAtendimento')
                    .content("Você realmente deseja excluir " + areaAtendimento.nome + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    areaAtendimentoService.removeAreaAtendimento ( areaAtendimento.id, {
                        callback: function ( result ) {

                            $scope.model.pageRequest.content.splice(  $scope.model.pageRequest.content.indexOf(areaAtendimento), 1 );

                            $scope.toast("Area de Atendimento excluido com sucesso");

                        }, errorHandler: function ( message, exception ) {

                            $rootScope.toast(message);

                        }
                    })

                });


            };

            
            
            $scope.changeToEdit = function (ev, areaAtendimento) {
                
                $mdDialog.show({
                        controller: AreaAtendimentoDialogController,
                        templateUrl: 'modules/home/views/areaAtendimento/areaAtendimento-dialog/areaAtendimento-dialog.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose:true,
                        locals: {areaAtendimento: angular.copy(areaAtendimento) }
                    })
                    .then(function(answer) {

                        var idx = $scope.model.pageRequest.content.indexOf(areaAtendimento);

                        if( idx > -1 ){

                            //editou
                            $scope.model.pageRequest.content[idx] = answer;

                        } else {
                            //Novo dado
                            $scope.model.pageRequest.content.unshift( answer );

                        }

                    });
          
            };

            function AreaAtendimentoDialogController($scope, $mdDialog, areaAtendimento) {

                $scope.areaAtendimento = areaAtendimento;

                $scope.model = {};

                $scope.save = function( areaAtendimento ){

                    if (!areaAtendimento.id) {

                        areaAtendimentoService.insertAreaAtendimento(areaAtendimento, {
                            callback: function (result) {

                                $rootScope.toast("Área de Atendimento inserido com sucesso");

                                $mdDialog.hide(result);

                            }, errorHandler: function (message, exception) {

                                $rootScope.toast(message);

                            }
                        })
                    } else {
                        areaAtendimentoService.updateAreaAtendimento(areaAtendimento, {
                            callback: function (result) {

                                $rootScope.toast("Area de Atendimento atualizado com sucesso");

                                $mdDialog.hide(result);

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    }

                };

                $scope.hide = function() {
                    $mdDialog.hide();
                };
                $scope.cancel = function() {
                    $mdDialog.cancel();
                };
                $scope.answer = function( areaAtendimento ) {

                    $scope.save(areaAtendimento);

                };


            }

            //


            $scope.listAreaAtendimento();

        });

}(window.angular));
