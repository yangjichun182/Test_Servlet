package com.pactera.controler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pactera.domain.Student;
import com.pactera.services.StudentService;

@RequestMapping("/html/test")
@Controller
public class StudentController {
	
	@Autowired(required=true)
	private StudentService studentService;
	
	@RequestMapping("/student")
	public Map<String,String> getStudentInfo(String id, HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		Student student = studentService.getStudent(id);
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:springMvc/spring-mvc.xml");
		//classpath:spring/application.xml
//		//classpath:springMvc/spring-mvc.xml
//		StudentController studentAction = (StudentController) context.getBean("StudentController");
//		StudentService studentService = new StudentService();
//		Student student = studentAction.studentService.getStudent("002");
		System.out.println("student"+student);
		String name = student.getNAME();
		String id2 = student.getID();
		String sex = student.getSEX();
		System.out.println(id+"--"+name+"--"+sex);
		map.put("name", name);
		map.put("sex", sex);
		map.put("id2", id2);
		return map;
	}

	@Test
	public void test1() {
		// 鑾峰彇涓婁笅鏂囧璞�
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContex.xml");
		StudentController studentAction = (StudentController) context
				.getBean("studentController");
		System.out.println(studentAction);

		 Student student = new Student("004","灏忔槑","鐢�",20);
		 studentAction.studentService.save(student);
//		Student std = studentAction.studentService.getStudent("001");
//		System.out.println(std);
	}
	
	@Test
	public void test2(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring/application.xml");
		StudentController studentAction = (StudentController) context
				.getBean("studentController");
//		StudentService studentService = new StudentService();
		Student student = studentAction.studentService.getStudent("002");
		String name = student.getNAME();
		System.out.println(name);
	}
}
