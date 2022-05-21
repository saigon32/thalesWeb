package thales.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import thales.web.dao.IEmployeeDao;
import thales.web.model.Employee;

/**
 * 
 * @author User:Andres Jurado, 20 May 2022.
 *
 *         for load the application put this url:
 *         http://localhost:8080/thalesWeb/consultEmployees the frameworks uses
 *         spring mvc, restful, angular 1.5 (oldy), patter (MVC) Model View
 *         and Controller api's created : 
 *         
 *         use case :
 *         http://localhost:8080/thalesWeb/EmployeeService/listEmployeeByName?name=s
 *         returns: [{"id":"02","name":"sidney","salary":"1000.00"}]
 * 
 *         http://localhost:8080/thalesWeb/EmployeeService/getEmployeeById?id=01
 *         returns [{"id":"01","name":"michael","salary":"1500.00"}]
 * 
 *         http://localhost:8080/thalesWeb/EmployeeService/listEmployees
 *         returns: [{"id":"01","name":"michael","salary":"1500.00"},
 *         {"id":"02","name":"sidney","salary":"1000.00"},
 *         {"id":"03","name":"george","salary":"600.00"}]
 *
 */

@RestController
@RequestMapping("/EmployeeService")
public class EmployeeService {

	@Autowired
	IEmployeeDao employeeDao;

	@RequestMapping(value = "/listEmployees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> listEmployees() {
		return employeeDao.listEmployees();
	}

	@RequestMapping(value = "/listEmployeeByName", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> listEmployeeByName(@RequestParam(value = "name", required = true) String name) {
		return employeeDao.listEmployeeByName(name);
	}

	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getEmployeeById(@RequestParam(value = "id", required = true) String id) {
		return employeeDao.getEmployeeById(id);
	}

	@RequestMapping(value = "/listEmployeeByIdName", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> listEmployeeByIdName(@RequestParam(value = "id", required = true) String id) {
		return employeeDao.listEmployeeByIdName(id);
	}

	@Transactional
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public void createEmployee(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "name", required = true) String name) throws Exception {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employeeDao.createEmployee(employee);
	}

	@Transactional
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public void updateEmployee(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "name", required = true) String name) throws Exception {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employeeDao.updateEmployee(employee);
	}

	@Transactional
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public void deleteEmployee(@RequestParam(value = "id", required = true) String id) throws Exception {
		employeeDao.deleteEmployee(id);
	}

}
