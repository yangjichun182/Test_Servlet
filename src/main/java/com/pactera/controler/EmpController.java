package com.pactera.controler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pactera.domain.Employees;
import com.pactera.services.EpmService;

@RequestMapping("/jsp")
@Controller
public class EmpController {
	@Autowired(required = true)
	private EpmService empService;

	@RequestMapping("/emp")
	public Map<String, String> getEmp(String id, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Employees emp = empService.getEmp(id);
		System.out.println("student" + emp);
		String name = emp.getFIRST_NAME();
		// String id2 = emp.getID();
		// String sex = emp.getSEX();
		System.out.println(id + "--" + name);
		map.put("name", name);
		// map.put("sex", sex);
		// map.put("id2", id2);
		return map;
	}
}
