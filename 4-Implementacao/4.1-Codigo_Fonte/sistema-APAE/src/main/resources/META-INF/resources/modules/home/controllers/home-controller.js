(function (angular) {
    'use strict';

    /**
     *
     * @param $scope
     * @param $state
     */
    angular.module('home')
        .controller('HomeController', function ($rootScope, $scope, $state, $importService, $mdToast, $mdDialog, $mdSidenav) {

            /*-------------------------------------------------------------------
             * 		 				 	ATTRIBUTES
             *-------------------------------------------------------------------*/
            //----STATES


            //-----
            /**
             *
             */
            $scope.menuSideNavId = "menuSideNav";

            $scope.teste = "HomeController";

            /*-------------------------------------------------------------------
             * 		 				  	POST CONSTRUCT
             *-------------------------------------------------------------------*/

            /*-------------------------------------------------------------------
             * 		 				 	  HANDLERS
             *-------------------------------------------------------------------*/
            /**
             *
             */
            $scope.toggleMenuSideNavHandler = function () {
                console.log("toggleMenuSideNavHandler");
                $mdSidenav($scope.menuSideNavId).toggle();
            };


            $rootScope.toast = function (text) {

                if( text.length > 1){
                    var position = {
                        bottom: false,
                        top: true,
                        left: false,
                        right: true
                    };
                    var toastPosition = angular.extend({},position);
                    var getToastPosition = function() {
                        return Object.keys(toastPosition)
                            .filter(function(pos) { return toastPosition[pos]; })
                            .join(' ');
                    };

                    var pinTo = getToastPosition();
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent(text)
                            .position( pinTo )
                            .hideDelay(3500)
                    );
                }

            };
        });

}(window.angular));