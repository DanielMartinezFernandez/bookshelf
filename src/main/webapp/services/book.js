'use strict';

angular.module('book')
.service('book', function ($http) {
  return {
      list: function (success) {
          return $http.get("/rest/book").then(success);
      },
      save: function (book, success) {
          return $http.post("/rest/book", book).then(success);
      },
      deleteBook: function (id, success) {
      	//console.log(id);
          return $http.delete("/rest/book/" + id).then(success);
      },
      detail: function (id, success) {
    	  console.log(id);
          return $http.get("/rest/book/" + id).then(success);
      }
  };
});