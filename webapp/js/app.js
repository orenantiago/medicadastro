
'use strict';
angular
.module('app', [])
.controller('controller', function controller($http, $scope){
	var self = this;
	$http.get('http://localhost:8080/exames').then(function(response) {
		console.log(response)
		self.exames = response.data;
	});

	$http.get('http://localhost:8080/pacientes').then(function(response) {
		console.log(response)
		self.pacientes = response.data;
	});

	$scope.deleteExam = function(exame) {
		console.log(exame.nome)
		$http.delete('http://localhost:8080/exames/' + exame.id).then(function(response) {
			console.log(response)
		})
	}

	$scope.addExam = function(exame) {
		console.log(exame.nome)
		$http.post('http://localhost:8080/exames/', exame).then(function(response) {
			console.log(response)
		})
	}


	$scope.addPacient = function(paciente) {
		console.log(paciente.nome)
		$http.post('http://localhost:8080/pacientes/', paciente).then(function(response) {
			console.log(response)
		});
	};

	$scope.deletePacient = function(paciente) {
		console.log(paciente.nome)
		$http.delete('http://localhost:8080/pacientes/' + paciente.id).then(function(response) {
			console.log(response)
		})
	};

});

angular.module('app').controller('meu.controller',[
        '$scope'
        ,'$http'
        ,function meuController($scope, $http){ console.info("Olá mundo") }
        ] );

angular
    .module('exams', [])
    .controller('examsController', examsController);

examsController.$inject = ['$http', '$scope'];
function examsController($http, $scope) {
	var self = this;
	$http.get('http://localhost:8080/exames').then(function(response) {
		console.log(response)
		self.exames = response.data;
	});

	$scope.delete = function(exame) {
		console.log(exame.nome)
		$http.delete('http://localhost:8080/exames/' + exame.id).then(function(response) {
			console.log(response)
		})
	}

	$scope.add = function(exame) {
		console.log(exame.nome)
		$http.post('http://localhost:8080/exames/', exame).then(function(response) {
			console.log(response)
		})
	}

}

angular
  .module('pacients', [])
  .controller('pacientsController', function controller($http, $scope) {
		var self = this;
		$http.get('http://localhost:8080/pacientes').then(function(response) {
			console.log(response)
			self.pacientes = response.data;

		});
		$scope.add = function(paciente) {
			console.log(paciente.nome)
			$http.post('http://localhost:8080/pacientes/', paciente).then(function(response) {
				console.log(response)
			});
		};

		$scope.delete = function(id) {
			console.log(id)
			$http.delete('http://localhost:8080/pacientes/' + id).then(function(response) {
				console.log(response)
			})
		};
	});
