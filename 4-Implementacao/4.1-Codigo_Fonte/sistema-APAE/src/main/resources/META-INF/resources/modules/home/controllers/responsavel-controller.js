/**
 * Created by lucas on 02/07/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('ResponsavelController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog, $mdSidenav ) {

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

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast("edsfwqsdfv", "red");
                        console.log("DEBUG");
                    }
                })
            };



            
            
            $scope.changeToDetail = function (ev, responsavel) {
                
                $mdDialog.show({
                        controller: ResponsavelDialogController,
                        templateUrl: 'modules/home/views/responsavel/responsavel-dialog/responsavel-dialog.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose:true,
                        locals: {responsavel: angular.copy(responsavel) }
                    })
                    .then(function(answer) {
                        $scope.status = 'You said the information was "' + answer + '".';
                    }, function() {
                        $scope.status = 'You cancelled the dialog.';
                    });
          
            };

            function ResponsavelDialogController($scope, $mdDialog, responsavel) {

                $scope.responsavel = responsavel;

                $scope.save = function( responsavel ){

                    if (!responsavel.id) {

                        responsavelService.insertResponsavel(responsavel, {
                            callback: function (result) {

                                $rootScope.toast("user.SaveUserSuccess", "green");
                                $state.go($scope.LIST_USER_STATE);
                                $scope.$apply();

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast($translate("emailUniqueViolation"), "red");
                            }
                        })
                    } else {
                        responsavelService.updateResponsavel(responsavel, {
                            callback: function (result) {

                                $rootScope.toast("");
                                $state.go($scope.LIST_USER_STATE);
                                $scope.$apply();

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast($translate("emailUniqueViolation"), "red");
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
                    $mdDialog.hide();
                    $scope.save(responsavel);
                };


            }

            //


            $scope.listResponsaveis();

        });

}(window.angular));
