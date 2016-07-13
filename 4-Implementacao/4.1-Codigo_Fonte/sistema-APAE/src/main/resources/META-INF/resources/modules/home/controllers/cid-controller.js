/**
 * Created by lucas on 02/07/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('CidController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog ) {

            $importService("cidService");

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


            $scope.listCidInativos = function () {
                cidService.listCidsByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum CID encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.listCid = function () {
                cidService.listCidsByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum CID encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };


            $scope.changeToEdit = function (ev, cid) {
                
                $mdDialog.show({
                        controller: CidDialogController,
                        templateUrl: 'modules/home/views/cid/cid-dialog/cid-dialog.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose:true,
                        locals: {cid: angular.copy(cid) }
                    })
                    .then(function(answer) {

                    });
          
            };

            function CidDialogController($scope, $mdDialog, cid) {

                $scope.cid = cid;

                $scope.save = function( cid ){

                    cidService.updateCid(cid, {
                        callback: function (result) {

                            $rootScope.toast("CID atualizado com sucesso");

                        }, errorHandler: function (message, exception) {
                            console.log(exception);
                        }
                    })

                };

                $scope.hide = function() {
                    $mdDialog.hide();
                };
                $scope.cancel = function() {
                    $mdDialog.cancel();
                };
                $scope.answer = function( responsavel ) {
                    $mdDialog.hide();
                    $scope.save(responsavel);
                };

            }

            $scope.listCid();

        });

}(window.angular));
