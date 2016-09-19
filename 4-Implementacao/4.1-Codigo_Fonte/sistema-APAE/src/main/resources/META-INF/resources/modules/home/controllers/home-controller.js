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


(function () {
    'use strict';

    /**
     * @ngdoc module
     * @name
     * @description
     */
    angular.module('eits.controls.paper-sheet1',
        ['eits.material.core', 'material.core'])
        .directive('eitsPaperSheet1', PaperSheetDirective)
        .directive('contentOpened1', ContentOpenedDirective)
        .directive('contentClosed1', ContentClosedDirective);

    /**
     * @ngdoc directive
     * @name eitsPaperSheet
     * @module eits.controls.paper-sheet
     *
     * @restrict E
     *
     * @description The `<eits-paper-sheet>` directive is a...
     *
     * @usage
     */
    function PaperSheetDirective($CONFIG) {
        return {
            restrict: 'E',
            transclude: true,
            scope: {
                onClose: '&?',
                onOpen: '&?'
            },
            compile: CompileHandler,
            controller: Controller,
            templateUrl: Template
        }

        /**
         *
         */
        function CompileHandler($compile) {
            return {
                pre: function preLink(scope, iElement) {
                	console.log("WANDERLEI");
                },
                post: function postLink(scope, iElement) {
					                	
					if( iElement.find('.paper-sheet-icon md-icon').length != 0 ){
                		iElement.find('.paper-sheet-icon md-icon').addClass( iElement.attr("close-icon") );
                	}
                	
                	//Se tiver o atributo 'disabled', então desabilita.
                	if( iElement[0].hasAttribute("disabled") ) {
                		iElement.children(".eits-paper-sheet-item").addClass("disabled");
                	}
                	
                    iElement[0].open = function () {
						
						if( iElement.find('.paper-sheet-icon md-icon').length != 0 )
						{
                    		iElement.find('.paper-sheet-icon md-icon').removeClass( iElement.attr("close-icon") ).addClass( iElement.attr("open-icon") );
                    	}
						
                        iElement.children('.eits-paper-sheet-item').addClass('clicked');
                        iElement[0].enable();
                        scope.onOpen();
                    }

                    iElement[0].close = function () {
						if( iElement.find('.paper-sheet-icon md-icon').length != 0 )
						{
                    		iElement.find('.paper-sheet-icon md-icon').removeClass( iElement.attr("close-icon") ).addClass( iElement.attr("open-icon") );
                    	}
						
                        iElement.children('.eits-paper-sheet-item').removeClass('clicked');
                        scope.onClose();
                    }
                    
                    //Desabilita
                    iElement[0].disable = function () {
                    	iElement.attr("disabled","")
                    	iElement.children(".eits-paper-sheet-item").addClass("disabled");
                    }
                    
                    //Habilita
                    iElement[0].enable = function () {
                    	if( iElement[0].hasAttribute("disabled") ) {
                        	iElement.removeAttr("disabled");
                        	iElement.children(".eits-paper-sheet-item").removeClass("disabled");
                        }
                    }

                    scope.onOpen = scope.onOpen != undefined ? scope.onOpen : function () {
                    };
                    scope.onClose = scope.onClose != undefined ? scope.onClose : function () {
                    };
                }
            };
        }

        /**
         *
         */
        function Controller($scope, $filter, $window, $templateCache, $element) {

            this.setClosedContent = function (element) {
                var closedContentElement = $element.children('.eits-paper-sheet-item').children('.paper-sheet-closed');
                closedContentElement.html(element);
            };

            this.setOpenedContent = function (element) {
                var openedContentElement = $element.children('.eits-paper-sheet-item').children('.paper-sheet-opened');
                openedContentElement.html(element);
            };

            $element.on('click', function (event) {
            	
            	if( $element[0].hasAttribute("disabled") ) {
            		return false;
            	}

                //if( $element.find('.paper-sheet-closed').find($(event.target)).length == 1 && $(event.target).closest('button').length == 0) {
            	if( ( $(event.target).prop('tagName') == 'H4' && $(event.target).closest('.eits-paper-sheet-item.clicked').length == 1 )
            		||
            	    $(event.target).closest('.eits-paper-sheet-item:not(.clicked)').length == 1) { 
                	
            		
                    $.each($('eits-paper-sheet1 div.clicked').parent(), function(index, elem){
                    	
                    	console.log( elem );
                    	
                        if($(elem).attr('id') != $element.attr('id'))
                        {
                        	elem.close();
                        	$(elem).find('.paper-sheet-icon md-icon').removeClass( $(elem).attr("open-icon") ).addClass( $(elem).attr("close-icon") ); 
                        }
                    });;

                    $element.children('.eits-paper-sheet-item').toggleClass('clicked');

                    if( !$element.children('.eits-paper-sheet-item').hasClass('clicked') ) 
					{
						
						if( $element.find('.paper-sheet-icon md-icon').length != 0 )
						{
                    		$element.find('.paper-sheet-icon md-icon').removeClass( $element.attr("open-icon") ).addClass( $element.attr("close-icon") ); 
                    	} 
						
                        $scope.onClose();
                    } else 
					{
						
						if( $element.find('.paper-sheet-icon md-icon').length != 0 )
						{
                    		$element.find('.paper-sheet-icon md-icon').removeClass( $element.attr("close-icon") ).addClass( $element.attr("open-icon") );
                    	}
						
                        $scope.onOpen();

                    }
                }

                /*if ($.contains($element.find('paper-sheet-closed'), event.target) && $(event.target).closest('button').length == 0 && !$element.children('.eits-paper-sheet-item').hasClass('clicked')) {
                    $element.children('.eits-paper-sheet-item').addClass('clicked');
                    $scope.onOpen();
                }
                if ( !$.contains($element[0], event.target) && $element.children('.eits-paper-sheet-item').hasClass('clicked') ) {
                    $element.children('.eits-paper-sheet-item').removeClass('clicked');
                    $scope.onClose();
                }*/
            });

            /*angular.element($window).on('click', function (event) {
                console.log($element);
                console.log($.contains($element[0], event.target));
                console.log($element.find('.paper-sheet-closed').find($(event.target)).length);
                if (!$.contains($element[0], event.target) && $element.find('.paper-sheet-closed').find($(event.target)).length == 0) {
                    $element.children('.eits-paper-sheet-item').removeClass('clicked');
                    $scope.onClose();
                }
            })*/
        }

        /**
         *
         */
        function Template(element, attributes) {
            return $CONFIG.path + '/controls/paper-sheet/paper-sheet-template.html';
        }
    }

    /**
     *
     */
    function ContentOpenedDirective() {
        return {
            restrict: 'E',
            require: '^eitsPaperSheet1',
            link: LinkHandler
        }

        /**
         *
         */
        function LinkHandler(scope, iElement, iAttributes, eitsPaperSheetController) {
            iElement.css('display', 'block');
            eitsPaperSheetController.setOpenedContent(iElement);
        }
    }

    /**
     *
     */
    function ContentClosedDirective() {
        return {
            restrict: 'E',
            require: '^eitsPaperSheet1',
            compile: CompileHandler
        }

        /**
         *
         */
        function CompileHandler() {
            return {
                pre: function preLink(scope, iElement) {
                },
                post: function postLink(scope, iElement, iAttributes, eitsPaperSheetController) {
                    eitsPaperSheetController.setClosedContent(iElement);
                }
            }
        }
    }


})();
