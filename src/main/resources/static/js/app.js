angular.module('TestAngular', ['ngRoute']).config(function($routeProvider) {
              
              $routeProvider.when('/', {
                             templateUrl: 'partial/machinery.html',
                             controller: 'machineryController'
              }).otherwise({
                             redirectTo: '/'
              });
              
});
