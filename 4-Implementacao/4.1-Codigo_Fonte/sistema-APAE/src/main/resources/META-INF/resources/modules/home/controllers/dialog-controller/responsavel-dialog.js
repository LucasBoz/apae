/**
 * Created by lucas on 20/09/2016.
 */
var ResponsavelDialogController = ["$scope", "$mdDialog", "$importService", "$rootScope","responsavel",
    function ($scope, $mdDialog, $importService, $rootScope, responsavel) {

        $importService("responsavelService");

        $scope.responsavel = responsavel;

        if (!$scope.responsavel) {
            $scope.responsavel = {telefones: []};
        }

        $scope.save = function (responsavel) {

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

        $scope.removeTelefone = function (telefone) {

            var idx = $scope.responsavel.telefones.indexOf(telefone);
            $scope.responsavel.telefones.splice(idx, 1);

        };

        $scope.hide = function () {
            $mdDialog.hide();
        };
        $scope.cancel = function () {
            $mdDialog.cancel();
        };
        $scope.answer = function (responsavel) {
            $scope.save(responsavel);
        };

}];
