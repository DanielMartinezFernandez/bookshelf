'use strict';
angular
    .module('book', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                //templateUrl: 'views/list.html',
            	templateUrl: 'views/table.html',
                controller: 'ListCtrl',
                controllerAs: 'list'
            })
            .when('/:id', {
                templateUrl: 'views/detail.html',
                controller: 'DetailCtrl',
                controllerAs: 'detail'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
