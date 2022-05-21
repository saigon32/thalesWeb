package thales.web.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import thales.web.dao.IEmployeeDao;
import thales.web.model.Employee;

@Repository
@Transactional
public class EmployeeDao implements IEmployeeDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void createEmployee(Employee employee) {
		this.entityManager.persist(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		this.entityManager.merge(employee);

	}

	@Override
	public void deleteEmployee(String id) {
		Employee employee = this.find(id);
		this.entityManager.remove(employee);
	}

	public Employee find(String id) {
		return this.entityManager.find(Employee.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeById(String id) {
		Query query = entityManager.createNamedQuery("Employee.findById");
		List<Employee> employee = (List<Employee>) query.setParameter("id", id).getResultList();
		return employee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employees = (List<Employee>) query.getResultList();
		return employees;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeeByName(String name) {
		List<Employee> employees = null;
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from Employee as e where e.name like :name");
			Query query = entityManager.createQuery(hql.toString());
			query.setParameter("name", "%" + name + "%");
			employees = (List<Employee>) query.getResultList();
		} catch (Exception exception) {
			throw exception;
		}
		return employees;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeeByIdName(String id) {
		List<Employee> employees = null;
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from Employee as e where e.id = :id");
			Query query = entityManager.createQuery(hql.toString());
			query.setParameter("id", id);
			employees = (List<Employee>) query.getResultList();
			if (employees.size() == 1) {
				employees = calculateSalaryEmployeePerYear(employees);
			}
		} catch (Exception exception) {
			throw exception;
		}
		return employees;
	}

	public List<Employee> calculateSalaryEmployeePerYear(List<Employee> employees) {
		try {
			Employee employee = employees.get(0);
			employees.clear();
			Double anualSalary = Double.parseDouble(employee.getSalary()) * 12;
			employee.setSalary(anualSalary.toString() + " salary per year");
			employees.add(0, employee);
		} catch (Exception exception) {
			throw exception;
		}
		return employees;
	}

}
