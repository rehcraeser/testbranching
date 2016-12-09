/**
 * Created by researcher on 07.12.2016.
 */
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.users=[];

    self.remove = remove;

    fetchAllUsers();

    function fetchAllUsers() {
        UserService.fetchAllUsers()
            .then(
                function(d) {
                    self.users = d;
                },
                function(errResponse) {
                    console.error('Error while fetching Users');
                }
            );
    }

    function deleteUser(id) {
        UserService.deleteUser(id)
            .then(
                fetchAllUsers,
                function(errResponse) {
                    console.error('Error while deleting User');
                }
            );
    }

    function remove(id) {
        console.log('id to be deleted', id);
        deleteUser(id);
    }
}]);