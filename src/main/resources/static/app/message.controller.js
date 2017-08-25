    'use strict';


    //InteractionController.$inject = ['$http'];


    app.controller("MessageController",['$scope', '$http', function($scope, $http) {
        $scope.messageList= [];
        var url = "/all";
        var messagePromise
            = $http.get(url);
        messagePromise.then(function(response){
            $scope.messageList = response.data;
        });



        $scope.add = function () {
            //alert(document.getElementById("message").value);
            var content = document.getElementById("message").value;

            var url = "/add/"+content;
            var messagePromise = $http.get(url);
            messagePromise.then(function(response){
                $scope.messageList = response.data;
            });
            document.getElementById("message").value = null;

    }
    }]);
