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
                        console.log("DEBUG");
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
                        locals: {responsavel: responsavel, content: $scope.model.pageRequest.content}
                    })
                    .then(function(answer) {

                    });
          
            };

            function ResponsavelDialogController($scope, $mdDialog, responsavel, content) {

                $scope.oldResponsavel = responsavel;

                $scope.responsavel =  angular.copy(responsavel);

                $scope.content = content;

                $scope.save = function( responsavel ){

                    if (!responsavel.id) {

                        responsavelService.insertResponsavel(responsavel, {
                            callback: function (result) {

                                $rootScope.toast("Responsável inserido com sucesso");

                                $scope.content.push( result );

                                $mdDialog.hide();

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    } else {
                        responsavelService.updateResponsavel(responsavel, {
                            callback: function (result) {

                                $rootScope.toast("Responsável atualizado com sucesso");

                                //Atualiza o responsavel da listagem
                                $scope.content[$scope.content.indexOf($scope.oldResponsavel)] = result;

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
                $scope.answer = function( responsavel ) {
                    $scope.save(responsavel);
                };


            }

            //


            $scope.listResponsaveis();

        });

}(window.angular));
