package com.learnjava.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/getmessage")
	public String getMessage() {
		logger.debug(" Message from Debug");
		logger.info(" Message from Info ");
		logger.error(" Message from Error ");
		return "hello message";
	}

}
