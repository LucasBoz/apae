/**
 * Created by lucas on 02/07/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('TransporteController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog ) {

            $importService("transporteService");

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


            $scope.listTransporte = function () {
                transporteService.listTransportesByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum transporte encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);

                    }
                })
            };

            $scope.removeTransporte = function (ev, transporte) {

                var confirm = $mdDialog.confirm()
                    .title('Excluir transporte')
                    .content("Você realmente deseja excluir o transporte " + transporte.nome + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    transporteService.removeTransporte ( transporte.id, {
                        callback: function ( result ) {

                            $scope.model.pageRequest.content.splice(  $scope.model.pageRequest.content.indexOf(transporte), 1 );

                            $scope.toast("Transporte excluido com sucesso");

                        }, errorHandler: function ( message, exception ) {

                            $rootScope.toast(message);

                        }
                    })

                });


            };

            
            
            $scope.changeToEdit = function (ev, transporte) {
                
                $mdDialog.show({
                        controller: TransporteDialogController,
                        templateUrl: 'modules/home/views/transporte/transporte-dialog/transporte-dialog.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose:true,
                        locals: {transporte: transporte, content: $scope.model.pageRequest.content }
                    })
                    .then(function(answer) {

                    });
          
            };

            function TransporteDialogController($scope, $mdDialog, transporte, content) {

                $scope.oldTransporte = transporte;
                $scope.content = content;

                $scope.transporte = angular.copy(transporte);

                $scope.save = function( transporte ){

                    if (!transporte.id) {

                        transporteService.insertTransporte(transporte, {
                            callback: function (result) {
                                $scope.content.push( result );
                                $rootScope.toast("Transporte inserido com sucesso");

                                $mdDialog.hide();

                            }, errorHandler: function (message, exception) {

                                $rootScope.toast(message);

                            }
                        })
                    } else {
                        transporteService.updateTransporte(transporte, {
                            callback: function (result) {

                                $rootScope.toast("Transporte atualizado com sucesso");

                                //Atualiza o responsavel da listagem
                                $scope.content[$scope.content.indexOf($scope.oldTransporte)] = result;

                                $mdDialog.hide();

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
                $scope.answer = function( transporte ) {

                    $scope.save(transporte);
                };


            }

            //


            $scope.listTransporte();

        });

}(window.angular));
