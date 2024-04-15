package com.prog.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpService;



@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp",emp);
		
		return "index";
	}
	@GetMapping("/addemp")
	public String addempform()
	{
		return "addemp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e) 
	{
		System.out.println(e);
		service.addEmp(e);
//		session.setAttribute("msg", "Employee Added Successfully..");
		
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e=service.getEMpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e) 
	{
		service.addEmp(e);
//		session.setAttribute("msg", "Emp data updated successfullt");
		return "redirect:/";		
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id) 
	{
		service.deleteEMp(id);
		return "redirect:/";
		
		
	}

}
