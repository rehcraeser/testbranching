/**
 * Created by researcher on 07.12.2016.
 */
angular.module('myApp').factory('UserService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/hibertest/user/';

    var factory = {
        fetchAllUsers: fetchAllUsers,
        deleteUser: deleteUser
    };

    return factory;

    function fetchAllUsers() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function deleteUser(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting User');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}]);