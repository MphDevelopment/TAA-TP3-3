package sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Employee;
import sample.data.jpa.service.EmployeeDAO;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	//http://localhost:8080/employee/create?firstName=bob&lastName=Dylan
	@RequestMapping("/employee/create")
	@ResponseBody
	public String create(String firstName, String lastName)
	{
		String employeeId;
		try
		{
			Employee employee = new Employee(firstName, lastName);
			employeeDao.save(employee);
			employeeId = String.valueOf(employee.getId());
		}catch (Exception e)
		{
			return "Error creating Employee object: " + e.toString();
		}
		return "Create Employee object with id " + employeeId;
	}
	
	@RequestMapping("/employee/delete")
	  @ResponseBody
	  public String delete(int id) {
	    try {
	      Employee employee = employeeDao.findById(id);
	      employeeDao.delete(employee);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	
	@RequestMapping("employee/get-by-firstname/{firstname}")
	  @ResponseBody
	  public String getByFirstName(@PathVariable("firstname") String firstName) {
		List<Employee> list;
	    try {
	      list = employeeDao.findByFirstName(firstName);
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "Users: " + list.toString();
	  }
	
	@RequestMapping("/employee/list")
	@ResponseBody
	public String list()
	{
		String ret = "";
		for(Employee e : employeeDao.findAll())
		{
			ret += e + "<br>";
		}
		return ret;
	}
	
	@RequestMapping("/employee/{id}")
	@ResponseBody
	public String getById(@PathVariable("id") int id) {
		Employee emp = employeeDao.findById(id);
		return emp.toString();
	}
	
	@RequestMapping("/employee/{id}/tasks")
	@ResponseBody
	public String getTasksForEmployee(@PathVariable("id") int id)
	{
		return employeeDao.findTasksForEmployee(id).toString();
	}
	
	@RequestMapping("/employee/{id}/projects")
	@ResponseBody
	public String getProjectsForEmployee(@PathVariable("id") int id)
	{
		return employeeDao.findProjectsForEmployee(id).toString();
	}
	
	@RequestMapping("employee/register")
	@ResponseBody
	public String employeeForm()
	{
		return "<html>\n" + 
				"	<body>\n" + 
				"		<FORM Method=\"POST\" Action=\"/employee/create\">\n" + 
				"			Firstname : 		<INPUT type=\"text\" size=\"20\" name=\"firstName\"><BR>\n" + 
				"			Lastname : 	<INPUT type=\"text\" size=\"20\" name=\"lastName\"><BR>\n" + 
				"			<INPUT type=submit value=Send>\n" + 
				"		</FORM>\n" + 
				"	</body>\n" + 
				"</html>";
	}
	
	
}
