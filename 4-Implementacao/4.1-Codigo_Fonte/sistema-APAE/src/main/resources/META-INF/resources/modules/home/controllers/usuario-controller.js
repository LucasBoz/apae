/**
 * Created by lucas on 02/07/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('UserController', function( $rootScope, $scope, $state, $importService, $mdToast, $mdDialog ) {

            $importService("accountService");

            $scope.model = {

                atualizarSenha : false,

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


            $scope.listUsers = function () {
                accountService.listUsersByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.removeUser = function (ev, user) {

                var confirm = $mdDialog.confirm()
                    .title('Excluir usuário')
                    .content("Você realmente deseja excluir o usuário " + user.name + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    accountService.removeUser ( user.id, {
                        callback: function ( result ) {

                            $scope.model.pageRequest.content = result.content;

                        }, errorHandler: function ( message, exception ) {
                            $rootScope.toast("message");

                        }
                    })

                });



            };

            $scope.changeToEdit = function (ev, user) {

                $mdDialog.show({
                        controller: UserDialogController,
                        templateUrl: 'modules/home/views/usuario/usuario-dialog/usuario-dialog.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose:true,
                        locals: {user: angular.copy(user) }
                    })
                    .then(function(answer) {

                    });

            };

            function UserDialogController($scope, $mdDialog, user) {

                $scope.user = user;

                $scope.save = function( user ){

                    if (!user.id) {

                        accountService.insertUser( user, {
                            callback: function (result) {

                                $rootScope.toast("Usuário inserido com sucesso");

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    } else {
                        accountService.updateUser(user, {
                            callback: function (result) {

                                $rootScope.toast("Usuário atualizado com sucesso");

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
                $scope.answer = function( user ) {
                    $mdDialog.hide();
                    $scope.save(user);
                };


            }

            $scope.listUsers();

        });

}(window.angular));
