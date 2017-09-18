
'use strict';
angular
.module('app', [
	'exams',
	'pacients'
]);

angular.module('app').controller('meu.controller',[
        '$scope'
        ,'$http'
        ,function meuController($scope, $http){ console.info("Olá mundo") }
        ] );

angular
    .module('exams', [])
    .controller('listExamsController', listExamsController);

listExamsController.$inject = ['$http'];
function listExamsController($http) {
	var self = this;
	$http.get('http://localhost:8080/exames').then(function(response) {
		console.log(response)
		self.exames = response.data;

	});
}
//CHECK IF TRUE
angular
	.module('exams')
	.controller('delExamController', function modify($http, $scope){
		var id = $scope.exame.id;
		$scope.delete = function() {
			console.log(id)
			$http.delete('http://localhost:8080/exames/' + id).then(function(response) {
				console.log(response)
				//self.pacientes = response.data;

			});
		};
	});
angular
	.module('exams')
	.controller('addExamController', function add($http, $scope){

		$scope.add = function() {
			$http.post('http://localhost:8080/exames/', $scope.exame).then(function(response) {
				console.log(response)
				//self.pacientes = response.data;

			});
		};
	});

angular
  .module('pacients', [])
  .controller('listPacientsController', function listPacientsController($http, $scope) {
		var self = this;
		$http.get('http://localhost:8080/pacientes').then(function(response) {
			console.log(response)
			self.pacientes = response.data;

		});
	});

	angular
	  .module('pacients', [])
	  .controller('listPacientsController', function form($http, $scope) {
			var self = this;
			$http.get('http://localhost:8080/pacientes').then(function(response) {
				console.log(response)
				self.pacientes = response.data;

			});
		});

//TODO

angular
	.module('pacients')
	.controller('delPacientController', function del($http, $scope){
		//var id = $scope.paciente.id;
		$scope.delete = function() {
			console.log(id)
			$http.delete('http://localhost:8080/pacientes/' + id).then(function(response) {
				console.log(response)
			})
			delete $scope.paciente
		};
		// $scope.show = function() {
		//
		// }
	});

	angular
		.module('pacients')
		.controller('addPacientController', function add($http, $scope){

			$scope.add = function() {
				$http.post('http://localhost:8080/pacientes/', $scope.paciente).then(function(response) {
					console.log(response)
					//self.pacientes = response.data;

				});
			};
		});
