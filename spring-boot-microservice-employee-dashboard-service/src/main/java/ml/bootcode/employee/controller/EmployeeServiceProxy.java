package ml.bootcode.employee.controller;

import java.util.Collection;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ml.bootcode.employee.models.EmployeeInfo;

@FeignClient(name = "EmployeeSearch")
@RibbonClient(name = "EmployeeSearch")
public interface EmployeeServiceProxy {

	@GetMapping("/employees/{id}")
	public EmployeeInfo findById(@PathVariable(value = "id") Long id);

	@GetMapping("/employees")
	public Collection<EmployeeInfo> findAll();
}
