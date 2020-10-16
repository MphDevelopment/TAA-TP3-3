package sample.data.jpa.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sample.data.jpa.domain.Employee;
import sample.data.jpa.domain.Project;
import sample.data.jpa.domain.Task;


@Transactional
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	public Employee findById(int id);
	
	//@Query("select e from Employee e where e.firstName = ?1")
	public List<Employee> findByFirstName(String firstName);
	
	public List<Employee> findByLastName(String lastName);
	
	@Query("select t from Task t where t.employee.id = ?1")
	public List<Task> findTasksForEmployee(int id);
	
	@Query("select e.projects from Employee e where id = ?1")
	public List<Project> findProjectsForEmployee(int id);

}
