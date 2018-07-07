package com.pactera.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pactera.domain.Student;

public class SpringTest {

	@Test
	public void test() {
		String path = SpringTest.class.getResource("/").toString();
		// System.out.println(path);

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		Student strudent=(Student) context.getBean("student");
		int age = strudent.getAGE();
		System.out.println(age);
	}

}
