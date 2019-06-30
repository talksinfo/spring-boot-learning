package com.talksinfo.helloworld.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.talksinfo.helloworld.beans.Employee;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeReportService {

	private List<Employee> empList = Arrays.asList(
			new Employee(1, "Sandeep", "Data Matrix", "Front-end Developer", 20000),
			new Employee(2, "Prince", "Genpact", "Consultant", 40000),
			new Employee(3, "Tom", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(4, "Tim", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(5, "Albert", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(6, "John", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(7, "Karthik", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(8, "Joe", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(9, "Gaurav", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(10, "Gaurav", "Silver Touch ", "Sr. Java Engineer", 47000),
			new Employee(11, "Abhinav", "Akal Info Sys", "CTO", 700000));

	public String generateReport() {
		try {
			
			//Inputstream jrxml file
			String fileName = "reports";
			ClassLoader classLoader = new EmployeeReportService().getClass().getClassLoader();
	        File file = new File(classLoader.getResource(fileName+"//employee-rpt.jrxml").getFile());
	        InputStream in = new FileInputStream(file);

			// Compile the Jasper report from .jrxml to .japser
			JasperReport jasperReport = JasperCompileManager.compileReport(in);

			// Get your data source
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(empList);

			// Add parameters
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Websparrow.org");

			// Fill the report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
					jrBeanCollectionDataSource);

			// Export the report to a PDF file
			//JasperExportManager.exportReportToHtmlFile(jasperPrint, "emp-html");
			JasperExportManager.exportReportToPdfFile(jasperPrint, "Emp-Rpt.pdf");

			System.out.println("Done");

			return "Report successfully generated";

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
