'use strict';

angular.module('book')
    .controller('DetailCtrl', function ($scope, $routeParams, book) {
    	book.detail($routeParams.id, function (item) {
            $scope.item = item.data;
        });
    });
