package ml.bootcode.employee.services;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import ml.bootcode.employee.model.Employee;

@Service
public class EmployeeSearchService {

	private static Map<Long, Employee> employeeRepository = null;

	static {
		Stream<String> employeeStream = Stream.of("1,Ashish,Howrah,Sr. Software Engineer,45000",
				"2,Sunny,Howrah,Software Engineer,40000", "3,Subhankar,Durgapur,Trainee Software Engineer,35000");
		
		employeeRepository = employeeStream.map(employeeStr -> {
			String[] info = employeeStr.split(",");
			return createEmployee(new Long(info[0]), info[1], info[2], info[3], new Integer(info[4]));
		}).collect(Collectors.toMap(Employee::getEmployeeId, emp -> emp));
	}

	private static Employee createEmployee(Long id, String name, String address, String designation, int salary) {
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		employee.setName(name);
		employee.setAddress(address);
		employee.setDesignation(designation);
		employee.setSalary(salary);
		return employee;
	}

	public Employee findById(Long id) {
		return employeeRepository.get(id);
	}

	public Collection<Employee> findAll() {
		return employeeRepository.values();
	}
}
