package com.jichun.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jichun.domain.Student;

public class SpringTest {

	@Test
	public void test() {
		String path = SpringTest.class.getResource("/").toString();
		// System.out.println(path);

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
		Student student = (Student) context.getBean("student");
		int age = student.getAGE();
		String name = student.getNAME();
		System.out.println("name:" + name + "===age:" + age);
		System.out.println(path);
	}

	@Test
	public void test_fileSystem() {
		//获取相对于当前文件的URI路径
		String path = SpringTest.class.getResource("/").toString();
		System.out.println(path);
		System.out.println(path+"../classes");//获取上级目录
		ApplicationContext context = new FileSystemXmlApplicationContext(path+"../classes/spring/application.xml");
		Student student = (Student) context.getBean("student");
		int age = student.getAGE();
		System.out.println(age);
	}

}
