var app = angular.module('app', ['ngRoute','ngResource', 'uiGmapgoogle-maps']);
app.config(function($routeProvider,  uiGmapGoogleMapApiProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .when('/roles',{
            templateUrl: '/views/roles.html',
            controller: 'rolesController'
        })

        /*.when('/', {
            templateUrl: 'index.html',
            controller: 'mainController'
        })*/

        .otherwise(
            { redirectTo: '/'}
        );

});
