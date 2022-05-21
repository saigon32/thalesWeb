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
 *         Api's rest:
 * 
 *         /thalesWeb/EmployeeService/listEmployeeByName param get name
 *         /thalesWeb/EmployeeService/getEmployeeById param get id
 *         /thalesWeb/EmployeeService/listEmployees no param
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
