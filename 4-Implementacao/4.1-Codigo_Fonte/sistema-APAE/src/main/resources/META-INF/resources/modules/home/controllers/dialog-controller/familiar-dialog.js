/**
 * Created by lucas on 20/09/2016.
 */
var ResponsavelDialogController = ["$scope", "$mdDialog", "$importService", "$rootScope","responsavel",
    function ($scope, $mdDialog, $importService) {

        $importService("responsavelService");



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
