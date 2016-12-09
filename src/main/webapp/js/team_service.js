/**
 * Created by researcher on 06.12.2016.
 */
angular.module('myApp').factory('TeamService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/hibertest/team/';

    var factory = {
        fetchAllTeams: fetchAllTeams,
        deleteTeam: deleteTeam
    };

    return factory;

    function fetchAllTeams() {
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Teams');
                    deferred.reject(errResponse);
                }
            );

        return deferred.promise;
    }

    function deleteTeam(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while deleting Team');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}]);