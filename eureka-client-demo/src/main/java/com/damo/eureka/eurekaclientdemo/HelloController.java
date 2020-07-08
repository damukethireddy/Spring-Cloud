package com.damo.eureka.eurekaclientdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//@RefreshScope
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
}
