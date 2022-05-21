<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Consult Employees</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	var app = angular.module('thalesWeb', []);
	app.controller('consultEmployees', [ '$scope', '$http', '$rootScope',
			function($scope, $http, $rootScope) {
				listEmployeeByName($scope, $http, $rootScope);
				getEmployeeById($scope, $http, $rootScope);
				listEmployeeByIdName($scope, $http, $rootScope);
				listEmployees($scope, $http, $rootScope);
			} ]);

	function listEmployeeByName($scope, $http, $rootScope) {
		$scope.listEmployeeByName = function(name) {
			if (name === undefined) {
				alert("Ingrese Nombre para realizar la busqueda o letras claves");
				return;
			}
			$http({
				url : '/thalesWeb/EmployeeService/listEmployeeByName',
				method : 'GET',
				params : {
					name : name
				}
			})
					.then(
							function mySuccess(response) {
								$scope.listEmployee = response.data;
							},
							function myError(response) {
								alert("Error cargando el servicio : /thalesWeb/EmployeeService/listEmployeeByName, error: "
										+ response.statusText);
							});
		}

	}

	function getEmployeeById($scope, $http, $rootScope) {
		$scope.getEmployeeById = function(id) {
			if (id === undefined) {
				alert("Ingrese ID para realizar la busqueda");
				return;
			}
			$http({
				url : '/thalesWeb/EmployeeService/getEmployeeById',
				method : 'GET',
				params : {
					id : id
				}
			})
					.then(
							function mySuccess(response) {
								$scope.listEmployee = response.data;
							},
							function myError(response) {
								alert("Error cargando el servicio : /thalesWeb/EmployeeService/getEmployeeById, error: "
										+ response.statusText);
							});
		}

	}

	function listEmployeeByIdName($scope, $http, $rootScope) {
		$scope.listEmployeeByIdName = function(id) {
			if (id === undefined || id === '') {
				listEmployees($scope, $http, $rootScope);
				return;
			} else {
				$http({
					url : '/thalesWeb/EmployeeService/listEmployeeByIdName',
					method : 'GET',
					params : {
						id : id
					}
				})
						.then(
								function mySuccess(response) {
									$scope.listEmployee = response.data;
								},
								function myError(response) {
									alert("Error cargando el servicio : /thalesWeb/EmployeeService/listEmployeeByIdName, error: "
											+ response.statusText);
								});
			}
		}
	}

	function listEmployees($scope, $http, $rootScope) {
		$http({
			url : '/thalesWeb/EmployeeService/listEmployees',
			method : 'GET'
		})
				.then(
						function mySuccess(response) {
							$scope.listEmployee = response.data;
						},
						function myError(response) {
							alert("Error cargando el servicio : /thalesWeb/EmployeeService/listEmployees, error: "
									+ response.statusText);
						});
	}
</script>
</head>
<body>
	<div ng-app="thalesWeb" ng-controller="consultEmployees"
		class="container">
		<h2>Consult Employees</h2>
		<form class="form-horizontal" action="/action_page.php">
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">Id Employee:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" ng-model="id"
						placeholder="Id" name="id">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default"
						ng-click="listEmployeeByIdName(id)">Query</button>
				</div>
			</div>
		</form>
		<table class="table table-striped table-bordered">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>SALARY</th>
			</tr>
			<tr ng-repeat="employee in listEmployee">
				<td>{{employee.id}}</td>
				<td>{{employee.name}}</td>
				<td>{{employee.salary}}</td>
			</tr>
		</table>
	</div>
</body>
<p align="left">Powered By: Andres Jurado</p>
</html>






