app.controller('usersController', function($scope) {
    $scope.headingTitle = "User List";
});

app.controller('rolesController', function($scope) {
    $scope.headingTitle = "Roles List";
});

app.controller('mainController', ['$scope', '$timeout', function($scope, $timeout) {

    //$scope.map = { center: { latitude: 45, longitude: -73 }, zoom: 12 };
    var marker = {
        draggable: true,
        id: Date.now(),
        coords: {
            latitude: 42.3349940452867,
            longitude: -71.0353168884369
        }
    };


    $scope.map =
     {
        center: {
            latitude: 42.3349940452867,
            longitude:-71.0353168884369
        },
        zoom: 13,
        markers: [],
        events: {
            click: function (map, eventName, originalEventArgs) {
                var e = originalEventArgs[0];
                var lat = e.latLng.lat(),lon = e.latLng.lng();
                var marker = {
                    id: Date.now(),
                    coords: {
                        latitude: lat,
                        longitude: lon
                    }
                };
                $scope.map.markers.push(marker);
                console.log($scope.map.markers);
                $scope.$apply();
            }
        }
     }


    var createMarker = function(title, bounds, idKey) {

      if (idKey == null) {
        idKey = 'id';
      }

      var ret = {
        coords: {
            latitude: bounds.lat,
            longitude: bounds.lng
        },
        title: 'm' + title
      };

      ret.id = title;
      return ret;
    };










    var options = {
        enableHighAccuracy: true
    };

    navigator.geolocation.getCurrentPosition(successGetMyLocation, errorGetMyLocation, options);

    function successGetMyLocation(pos) {
        $scope.myPosition = new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude);
        $scope.map.center.latitude = pos.coords.latitude;
        $scope.map.center.longitude = pos.coords.longitude;

        var marker = createMarker('Minha Localização',
                                   {lat: pos.coords.latitude,
                                   lng: pos.coords.longitude},
                                   'my-current-location')

        /*var marker = {
            draggable: true,
            id: Date.now(),
            coords: {
                latitude: pos.coords.latitude,
                longitude: pos.coords.longitude
            }
        };*/

        $scope.map.markers.push(marker);
    }

    function errorGetMyLocation(error) {
        alert('Unable to get your location.');
    }

    $scope.showModal = function() {
        var d = document.getElementById('mask');
        d.className += ' mask-appear';
    }

    $scope.closeModal = function() {
        var d = document.getElementById('mask');
        d.classList.remove('mask-appear');
    }

    /*$scope.w = window.innerWidth;
    $scope.h = window.innerHeight;

    $timeout(function() {
        var test = document.getElementsByClassName('.angular-google-map-container');
    }, 1000);*/


    //.style.width = $scope.w + 'px';

}]);
