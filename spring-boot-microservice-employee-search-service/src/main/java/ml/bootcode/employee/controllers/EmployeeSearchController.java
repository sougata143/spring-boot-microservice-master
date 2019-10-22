package ml.bootcode.employee.controllers;

import java.util.Collection;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.employee.model.Employee;
import ml.bootcode.employee.services.EmployeeSearchService;

@RestController
@RefreshScope
public class EmployeeSearchController {

	private EmployeeSearchService employeeSearchService;

	public EmployeeSearchController(EmployeeSearchService employeeSearchService) {
		this.employeeSearchService = employeeSearchService;
	}

	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeSearchService.findById(id);
	}

	@GetMapping("/employees")
	public Collection<Employee> findAll() {
		return employeeSearchService.findAll();
	}
}
