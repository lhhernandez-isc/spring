package com.hh.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}

	@RequestMapping("processForm")
	public String processForm(@ModelAttribute("student") Student student) {
//		log the input data
		System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
		return "student-confirmation";
	}

}
