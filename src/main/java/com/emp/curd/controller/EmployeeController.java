package com.emp.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emp.curd.dao.EmployeeDAO;
import com.emp.curd.entity.Employee;
import com.emp.curd.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String showList(Model theModel) {
		
		List<Employee> employees =employeeService.findAll();
		
		theModel.addAttribute("employees", employees);
		return "employees/employees-list";
		
	}

	@GetMapping("/showFormForAdd")
	public String showAddEmployee(Model theModel) {
		
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute ("employee") Employee theEmployee ) {
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/update")
	public String updateEmployee(@ModelAttribute ("employeeId") int theId, Model theModel) {
		
		Employee theEmployee = employeeService.getById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String updateEmployee(@ModelAttribute ("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		return "redirect:/employees/list";

	}

	
}
