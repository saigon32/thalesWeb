package thales.web.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import thales.web.model.Employee;

/**
 * 
 * 
 * @author User:Andres Jurado, 20 May 2022.
 *
 */

public interface IEmployeeDao {

	@Transactional
	public void createEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(String id);

	public List<Employee> getEmployeeById(String id);

	public List<Employee> listEmployees();

	public List<Employee> listEmployeeByName(String name);

	public List<Employee> listEmployeeByIdName(String id);

}
