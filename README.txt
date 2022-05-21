for load the application put this url: http://localhost:8080/thalesWeb/consultEmployees
the frameworks uses : spring mvc, restful, angular 1.5 (oldy), patter (MVC) Model View and Controller
api's created : 
use case : 
*  http://localhost:8080/thalesWeb/EmployeeService/listEmployeeByName?name=s 
   returns: [{"id":"02","name":"sidney","salary":"1000.00"}]
 
*  http://localhost:8080/thalesWeb/EmployeeService/getEmployeeById?id=01
   returns [{"id":"01","name":"michael","salary":"1500.00"}]

*  http://localhost:8080/thalesWeb/EmployeeService/listEmployees 
   returns: [{"id":"01","name":"michael","salary":"1500.00"},
			 {"id":"02","name":"sidney","salary":"1000.00"},
			 {"id":"03","name":"george","salary":"600.00"}]