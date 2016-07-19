app.controller('usersController', function($scope) {
    $scope.headingTitle = "User List";
});

app.controller('rolesController', function($scope) {
    $scope.headingTitle = "Roles List";
});

app.controller('mainController', ['$scope', '$timeout', '$http', function($scope, $timeout, $http) {

    //$scope.map = { center: { latitude: 45, longitude: -73 }, zoom: 12 };
    var marker = {
        draggable: true,
        id: Date.now(),
        coords: {
            latitude: 42.3349940452867,
            longitude: -71.0353168884369
        }
    };

    $scope.today = new Date();
    $scope.day = $scope.today.getUTCDate();
    $scope.month = $scope.today.getUTCMonth() + 1;
    $scope.year = $scope.today.getUTCFullYear();
    $scope.todayString = $scope.day + '-' + $scope.month + '-' + $scope.year;

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


    $scope.choosenEvent = {};

    $scope.onMarkerClick = function(marker, eventName, mk) {
        if(marker.key != 'my-current-location') {
            $scope.choosenEvent = $scope.events[marker.key];
            $scope.showModal();
        }
    };

    var options = {
        enableHighAccuracy: true
    };

    navigator.geolocation.getCurrentPosition(successGetMyLocation, errorGetMyLocation, options);

    function successGetMyLocation(pos) {
        //$scope.myPosition = new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude);

        $scope.myPosition = {lat:0, lng:0};

        $scope.myPosition.lat = pos.coords.latitude;
        $scope.myPosition.lng = pos.coords.longitude;

        $scope.map.center.latitude = pos.coords.latitude;
        $scope.map.center.longitude = pos.coords.longitude;

        var marker = createMarker('my-current-location',
                                   {lat: pos.coords.latitude,
                                   lng: pos.coords.longitude},
                                   'my-current-location');


        $scope.getEventsByFilters({ dateStart: $scope.todayString, dateEnd: $scope.todayString, lat: pos.coords.latitude, lng: pos.coords.longitude });

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

    $scope.getEventsByFilters = function(filters) {
        $http.get('/events/range/'+ filters.dateStart +'/' + filters.dateEnd + '/lat/' + filters.lat + '/long/' + filters.lng).then(successGetEvents, errorGetEvents);
    }

    $scope.filterHoje = function() {
        $scope.getEventsByFilters({ dateStart: $scope.todayString, dateEnd: $scope.todayString, lat: $scope.myPosition.lat, lng: $scope.myPosition.lng });
    }

    $scope.filterSemana = function() {
        var nextWeek = new Date($scope.today.getTime() + 7 * 24 * 60 * 60 * 1000);

        var nextWeekDate = nextWeek.getUTCDate() + '-' + (nextWeek.getUTCMonth() + 1) + '-' + nextWeek.getUTCFullYear();

        $scope.getEventsByFilters({ dateStart: $scope.todayString, dateEnd: nextWeekDate, lat: $scope.myPosition.lat, lng: $scope.myPosition.lng });
    }

    $scope.filterMes = function() {
        var now = new Date();
        var current = {};
        if (now.getMonth() == 11) {
            current = new Date(now.getFullYear() + 1, 0, 1);
        } else {
            current = new Date(now.getFullYear(), now.getMonth() + 1, 1);
        }

        var nextMonth = current.getUTCDate() + '-' + (current.getUTCMonth() + 1) + '-' + current.getUTCFullYear();
        $scope.getEventsByFilters({ dateStart: $scope.todayString, dateEnd: nextMonth, lat: $scope.myPosition.lat, lng: $scope.myPosition.lng });

    }


    function successGetEvents(response) {
        $scope.events = response.data;

        var i = 0;
        for(i; i < $scope.events.length; i++) {
            var marker = createMarker( i ,
                                       {lat: $scope.events[i].lat,
                                       lng: $scope.events[i].lng},
                                       'my-current-location');
            $scope.map.markers.push(marker);
        }

    }

    function errorGetEvents(error) {
        alert('Ocorreu um erro ao tentar recuperar os eventos');
    }

}]);
