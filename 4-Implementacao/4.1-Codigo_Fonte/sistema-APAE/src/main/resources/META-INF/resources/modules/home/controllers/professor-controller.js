/**
 * Created by lucas on 11/06/2016.
 */
(function ( angular ) {
    'use strict';

    /**
     *
     */
    angular.module('home')
        .controller('ProfessorController', function( $rootScope, $scope, $state, $importService, $mdDialog ) {

            $importService("professorService");

            /*-------------------------------------------------------------------
             *                          ATTRIBUTES
             *-------------------------------------------------------------------*/


            $scope.professors = [];

            $scope.professor = {
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

            $scope.listProfessors = function () {
                professorService.listByFilters ( null, null, {
                    callback: function ( result ) {

                        $scope.model.pageRequest.content = result.content;

                        if( !$scope.model.pageRequest.content.length){
                            $rootScope.toast("Nenhum professor encontrado");
                        }

                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.changeToDetail = function ( professor ) {
                professorService.findProfessorById ( professor.id, {
                    callback: function ( result ) {
                        $scope.professor = result;
                        $state.go( "professor.new" );
                    }, errorHandler: function ( message, exception ) {
                        $rootScope.toast(message);
                    }
                })
            };

            $scope.removeProfessor = function (ev, professor) {

                $scope.professor = professor;

                var confirm = $mdDialog.confirm()
                    .title('Excluir professor')
                    .content("Você realmente deseja excluir o professor " + professor.nome + "?")
                    .targetEvent(ev)
                    .ok('Excluir')
                    .cancel('Cancelar');
                $mdDialog.show(confirm).then(function () {

                    professorService.removeProfessor ( professor.id, {
                        callback: function ( result ) {

                            $rootScope.toast("Professor removido com sucesso");

                            $scope.model.pageRequest.content.splice(  $scope.model.pageRequest.content.indexOf(  $scope.professor ), 1 );


                        }, errorHandler: function ( message, exception ) {
                            $rootScope.toast(message);

                        }
                    })

                });
            };



            $scope.save = function( professor ){

                if (!professor.id) {

                    professorService.insertProfessor(professor, {
                        callback: function (result) {

                            $rootScope.toast("Professor inserido com sucesso");

                            $state.go( "professor.list" );

                        }, errorHandler: function (message, exception) {
                            $rootScope.toast(message);
                        }
                    })
                } else {
                    professorService.updateProfessor(professor, {
                        callback: function (result) {

                            $rootScope.toast("Professor atualizado com sucesso");
                            $state.go( "professor.list" );

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
                    templateUrl: 'modules/home/views/professor/formacao-dialog/formacao-dialog.html',
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
                        $scope.professor.formacoes[$scope.professor.formacoes.indexOf(formacao)] = result;

                    } else {
                        $scope.professor.formacoes.push( result );
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


            /*-------------------------------------------------------------------
             *                          INITS
             *-------------------------------------------------------------------*/

            $scope.listProfessors();


        });

}(window.angular));