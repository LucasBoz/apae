/**
 * Created by lucas on 11/06/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('TecnicoController', function( $rootScope, $scope, $state, $importService, $mdDialog ) {

            $importService("tecnicoService");

            $importService("accountService");

            /*-------------------------------------------------------------------
             *                          ATTRIBUTES
             *-------------------------------------------------------------------*/


            $scope.tecnicos = [];

            $scope.tecnico = {
                cursosEspecificos : [],
                funcao : [],
                formacoes : []
            };


            /**
             *
             */
            $scope.model = {

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

            $scope.funcoes = [
                { name : "DOCENTE" , value: "Docente"},
                { name : "AUXILIAR_EDUCACIONAL" , value: "Auxiliar/Assistente Educacional"},
                { name : "MONITOR_ATIVIDADE_COMPLEMENTAR" , value: "Profissional/Monitor de atividade complementar"},
                { name : "TRADUTOR_INTERPRETE_LIBRAS" , value: "Tradutor intérprete de libras"},
                { name : "DOCENTE_TITULAR" , value: "Docente titular - Coordenador de tutoria"},
                { name : "DOCENTE_TUTOR" , value: "Docente tutor - Auxiliar"}
            ];

            $scope.cursosEspecificos = [
                {   name : 'CRECHE',     value : "Creche(0 a 3 anos)" },
                {   name : 'PRE_ESCOLA', value : "Pré escola(4 e 5 anos)" },
                {   name : 'ANOS_INICIAIS_ENSINO_FUNDAMENTAL', value : "Anos iniciais do ensino fundamental" },
                {   name : 'ANOS_FINAIS_ENSINO_FUNDAMENTAL',   value : "Anos finais do ensino fundamental" },
                {   name : 'ENSINO_MEDIO', value : "Ensino médio" },
                {   name : 'EDUCACAO_JOVENS_ADULTOS', value : "Educação de jovens e adultos" },
                {   name : 'EDICACAO_ESPECIAL', value : "Educação especial" },
                {   name : 'EDUCACAO_INDIGENA', value : "Educação indígena" },
                {   name : 'EDUCACAO_CAMPO', value : "Educação do campo" },
                {   name : 'EDUCACAO_AMBIENTAL', value : "Educação ambiental" },
                {   name : 'EDUCACAO_DIREITOS_HUMANOS', value : "Educação em direitos humanos" },
                {   name : 'GENERO_DIVERSIDADE_SEXUAL', value : "Gênero e diversidade sexual" },
                {   name : 'DIREITOS_CRIANCA_ADOLECENTE', value : "Direitos da criança e adolescente" },
                {   name : 'RELACOES_ETNIRACIAIS', value : "Educação para as relações etnorraciais e história e cultura afro-brasileira e africana" },
                {   name : 'OUTROS', value : "Outros" },
                {   name : 'NENHUM', value : "Nenhum" }
            ];


            /*-------------------------------------------------------------------
             *                            HANDLERS
             *-------------------------------------------------------------------*/

            $scope.listTecnicos = function () {
                tecnicoService.listByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum tecnico encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.changeToDetail = function ( tecnico ) {
                tecnicoService.findTecnicoById ( tecnico.id, {
                    callback: function ( result ) {
                        $scope.tecnico = result;
                        $state.go( "tecnico.new" );
                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.removeTecnico = function (ev, tecnico) {

                $scope.tecnico = tecnico;

                var confirm = $mdDialog.confirm()
                    .title('Excluir tecnico')
                    .content("Você realmente deseja excluir o tecnico " + tecnico.nome + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    tecnicoService.removeTecnico ( tecnico.id, {
                        callback: function ( result ) {

                            $rootScope.toast("Tecnico removido com sucesso");

                            $scope.model.pageRequest.content.splice(  $scope.model.pageRequest.content.indexOf(  $scope.tecnico ), 1 );


                        }, errorHandler: function ( message, exception ) {
                            $rootScope.toast(message);

                        }
                    })

                });
            };



            $scope.save = function( tecnico ){

                if(tecnico.user){

                    tecnico.user.name = tecnico.nome;

                    if (!tecnico.user.id) {

                        accountService.insertUser( tecnico.user, {
                            callback: function (result) {

                                tecnico.user = result;
                                $scope.saveTecnico(tecnico);

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    } else {
                        accountService.updateUser(tecnico.user, {
                            callback: function (result) {

                                tecnico.user = result;
                                $scope.saveTecnico(tecnico);

                            }, errorHandler: function (message, exception) {
                                $rootScope.toast(message);
                            }
                        })
                    }

                } else {
                    $scope.saveTecnico(tecnico);
                }

            };

            $scope.saveTecnico = function (tecnico) {
                if (!tecnico.id) {
                    tecnicoService.insertTecnico(tecnico, {
                        callback: function (result) {

                            $rootScope.toast("Tecnico inserido com sucesso");
                            $state.go( "tecnico.list" );

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                } else {
                    tecnicoService.updateTecnico(tecnico, {
                        callback: function (result) {

                            $rootScope.toast("Tecnico atualizado com sucesso");
                            $state.go( "tecnico.list" );

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                }
            };


            $scope.toggle = function (item, list) {

                var idx = list.indexOf(item);
                if (idx > -1) {
                    list.splice(idx, 1);
                }
                else {
                    list.push(item);
                }
            };

            $scope.exists = function (item, list) {
                return list.indexOf(item) > -1;
            };


            /**
             * POPUP
             */

            $scope.formacaoDialog = function (ev, formacao) {

                $mdDialog.show({
                    controller: FormacaoDialogController,
                    templateUrl: 'modules/home/views/tecnico/formacao-dialog/formacao-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose:true,
                    locals: { formacao: angular.copy(formacao),
                              popupConfig: {
                                    title : formacao ? "Editar formação" : "Nova formação",
                                    buttonConfirm: formacao ? "Editar" : "Salvar"
                              }
                    }
                })
                .then(function( result ) {

                    if ( formacao ) {
                        //editou
                        $scope.tecnico.formacoes[$scope.tecnico.formacoes.indexOf(formacao)] = result;

                    } else {
                        $scope.tecnico.formacoes.push( result );
                    }
                });

            };

            function FormacaoDialogController($scope, $mdDialog, formacao, popupConfig) {

                $scope.formacao =  formacao ;
                $scope.popupConfig  = popupConfig;


                $scope.cancel = function() {
                    $mdDialog.cancel();
                };

                $scope.answer = function( formacao ) {

                    var formacaoForm = angular.element( document.querySelector('#formacaoForm') ).scope()['formacaoForm'];

                    $mdDialog.hide( formacao )
                };

            }

            $scope.editUser = function (ev, tecnico) {

                $mdDialog.show({
                    controller: UserDialogController,
                    templateUrl: 'modules/home/views/tecnico/usuario-dialog/usuario-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose:true,
                    locals: {user: angular.copy( tecnico.user ), tecnico : tecnico }
                })
                    .then(function(answer) {
                        if(answer){
                            tecnico.user = answer;
                        }
                    });

            };

            function UserDialogController($scope, $mdDialog, tecnico, user) {

                $scope.user = {

                    name : tecnico.nome,
                    role : 'TECNICO',
                    enabled  : 'true',
                    login : user ? user.login : '',
                    id: tecnico.user ? tecnico.user.id : null

                };


                $scope.hide = function() {
                    $mdDialog.hide();
                };
                $scope.cancel = function() {
                    $mdDialog.cancel();
                };
                $scope.answer = function( user ) {
                    $mdDialog.hide(user);
                };


            }



            /*-------------------------------------------------------------------
             *                          INITS
             *-------------------------------------------------------------------*/

            $scope.listTecnicos();


        });

}(window.angular));