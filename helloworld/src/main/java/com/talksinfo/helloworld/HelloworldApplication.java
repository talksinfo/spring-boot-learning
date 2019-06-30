package com.talksinfo.helloworld;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.talksinfo.helloworld.service.EmployeeReportService;

@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HelloworldApplication.class, args);
		
		ApplicationContext ctx = SpringApplication.run(HelloworldApplication.class, args);
        
        String[] beanNames = ctx.getBeanDefinitionNames();
         
        Arrays.sort(beanNames);
 
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
	}

	@Bean
	public String generateReport(final EmployeeReportService employeeReportService) {

		String msg = employeeReportService.generateReport();

		System.out.println(msg);

		return msg;
	}
}
