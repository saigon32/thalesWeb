<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Employee</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	var app = angular.module('thalesWeb', []);
	app.controller('adminEmployee', [ '$scope', '$http', '$rootScope',
			function($scope, $http, $rootScope) {
				listEmployees($scope, $http, $rootScope);
				createEmployee($scope, $http, $rootScope);
			} ]);

	function listEmployees($scope, $http, $rootScope) {
		$http({
			url : '/thalesWeb/EmployeeService/listEmployees',
			method : 'GET'
		})
				.then(
						function mySuccess(response) {
							$scope.listEmployees = response.data;
						},
						function myError(response) {
							alert("Error cargando el servicio : /thalesWeb/EmployeeService/listEmployees, error: "
									+ response.statusText);
						});
	}

	function createEmployee($scope, $http, $rootScope) {
		$scope.createEmployee = function(id, name) {
			if (id === undefined || name === undefined) {
				alert("Ingrese ID, Nombre, para realizar el ingreso");
				return;
			}
			$http({
				url : '/thalesWeb/EmployeeService/createEmployee',
				method : 'GET',
				params : {
					id : id,
					name : name
				}
			})
					.then(
							function mySuccess(response) {
								$scope.listEmployees = response.data;
							},
							function myError(response) {
								alert("Error cargando el servicio : /thalesWeb/EmployeeService/createEmployee, error: "
										+ response.statusText);
							});
		}

	}
</script>
</head>
<body>
	<div ng-app="thalesWeb" ng-controller="adminEmployee" class="container">
		<h2>Admin Employee</h2>
		<form class="form-horizontal" action="/action_page.php">
			<div class="form-group">
				<label class="control-label col-sm-2" for="Id">Id :</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" ng-model="id"
						placeholder="Id" name="id">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" ng-model="name"
						placeholder="name" name="name">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default"
						ng-click="createEmployee(id,name)">Create</button>
				</div>
			</div>
		</form>
		<table class="table table-striped table-bordered">
			<tr>
				<th>ID</th>
				<th>NAME</th>
			</tr>
			<tr ng-repeat="employee in listEmployees">
				<td>{{employee.id}}</td>
				<td>{{employee.name}}</td>
			</tr>
		</table>
	</div>
</body>
<p align="left">Powered By: Andres Jurado</p>
</html>






