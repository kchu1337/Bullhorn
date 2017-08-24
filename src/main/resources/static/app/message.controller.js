    'use strict';


    //InteractionController.$inject = ['$http'];

    app.controller("MessageController",['$scope', '$http', function($scope, $http) {
        var url = "/all";
        var messagePromise
            = $http.get(url);
        messagePromise.then(function(response){
            $scope.messageList = response.data;
        });



        $scope.add = function () {
            //alert(document.getElementById("message").value);
            var content = document.getElementById("message").value;
            var name = document.getElementById("user").value;

            var url = "/add/"+content+ "/"+name;
            var imageLikePromise = $http.get(url);
            imageLikePromise.then(function(response){
                $scope.messageList = response.data;
            });
            document.getElementById("message").value = null;
            document.getElementById("user").value = null;


    }
    }]);
