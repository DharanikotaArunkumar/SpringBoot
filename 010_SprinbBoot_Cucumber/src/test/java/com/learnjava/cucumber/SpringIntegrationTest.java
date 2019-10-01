package com.learnjava.cucumber;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CucumberApplication.class, 
		  loader = SpringBootContextLoader.class)
@SpringBootTest(classes = CucumberApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)		
public class SpringIntegrationTest {

}
