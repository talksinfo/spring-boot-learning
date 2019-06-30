package com.talksinfo.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talksinfo.helloworld.service.EmployeeReportService;

@RestController
@RequestMapping("/employee")
public class EmployeeReportController {

	@Autowired
	private EmployeeReportService employeeReportService;

	@GetMapping("/report")
	public String empReport() {

		return employeeReportService.generateReport();
	}
}
