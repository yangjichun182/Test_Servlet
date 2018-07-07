package com.pactera.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping(path = "/pactera")
public class HelloWorldControler {

	@RequestMapping(path = "/a")
	public String testHello(){
		return "/parameter";
	}
}
