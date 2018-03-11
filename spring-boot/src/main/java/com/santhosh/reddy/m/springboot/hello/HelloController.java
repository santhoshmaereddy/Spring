package com.santhosh.reddy.m.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(method=RequestMethod.GET,value="/spring-boot/api/hello")
	public String hello() {
		return "hello from spring boot";
	}
	
	
	
}
