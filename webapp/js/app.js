
'use strict';
angular
.module('app', [
	'exams',
	'pacients'
]);

angular.module('app',[]).controller('meu.controller',[
        '$scope'
        ,'$http'
        ,function meuController($scope, $http){ console.info("Olá mundo") }
        ] );

angular
    .module('exams')
    .controller('listExamsController', listExamsController);

listExamsController.$inject = ['$http'];
function listExamsController($http) {
	var self = this;
	$http.get('http://localhost:8080/exames').then(function(response) {
		console.log(response)
		self.exames = response.data;

	});
}

angular
  .module('pacients', [])
  .controller('listPacientsController', function listPacientsController($http) {
		var self = this;
		$http.get('http://localhost:8080/pacientes').then(function(response) {
			console.log(response)
			self.pacientes = response.data;

		});
	});

//TODO

// angular
// 	.module('pacients')
// 	.controller('deletePacientController', function delPacient($http, $scope){
// 		var id = $scope.paciente.id;
// 		console.log(id);
// 	});
