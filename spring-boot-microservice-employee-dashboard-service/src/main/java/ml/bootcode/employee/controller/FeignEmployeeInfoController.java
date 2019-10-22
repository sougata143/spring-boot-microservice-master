package ml.bootcode.employee.controller;

import java.util.Collection;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ml.bootcode.employee.models.EmployeeInfo;

@RestController
@RefreshScope
public class FeignEmployeeInfoController {

	private EmployeeServiceProxy proxyService;

	public FeignEmployeeInfoController(EmployeeServiceProxy proxyService) {
		this.proxyService = proxyService;
	}

	@GetMapping("/dashboard/feign/{myself}")
	public EmployeeInfo findById(@PathVariable Long myself) {
		return proxyService.findById(myself);
	}

	@GetMapping("/dashboard/feign/peers")
	public Collection<EmployeeInfo> findAll() {
		return proxyService.findAll();
	}
}
