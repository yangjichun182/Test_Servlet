package com.jichun.controler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jichun.domain.Student;
import com.jichun.services.StudentService;

@RequestMapping("/jsp/test")
@Controller
public class StudentController {
	
	@Autowired(required = true)
	private StudentService studentService;

	@RequestMapping("/student")
	public Map<String, String> getStudentInfo(String id, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Student student = studentService.getStudent(id);
		System.out.println("student" + student);
		String name = student.getNAME();
		String id2 = student.getID();
		String sex = student.getSEX();
		System.out.println(id + "--" + name + "--" + sex);
		map.put("name", name);
		map.put("sex", sex);
		map.put("id2", id2);
		return map;
	}

	/**
	 * 2018-11-03
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	/**
	 * 2018-11-03
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}


}
