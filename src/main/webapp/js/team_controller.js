/**
 * Created by researcher on 06.12.2016.
 */
angular.module('myApp').controller('TeamController', ['$scope', 'TeamService', function($scope, TeamService) {
    var self = this;
    self.teams=[];

    self.remove = remove;

    fetchAllTeams();

    function fetchAllTeams() {
        TeamService.fetchAllTeams()
            .then(
                function(d) {
                    self.teams = d;
                },
                function(errResponse) {
                    console.error('Error while fetching Teams');
                }
            );
    }

    function deleteTeam(id) {
        TeamService.deleteTeam(id)
            .then(
                fetchAllTeams,
                function(errResponse) {
                    console.error('Error while deleting Team');
                }
            );
    }

    function remove(id) {
        console.log('id to be deleted', id);
        deleteTeam(id);
    }
}]);