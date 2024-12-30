package ru.prokhor.lab_6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
    @GetMapping("/hello")
    public String sayHello() {
		logger.info("Handling /hello request");
		return "Hello, World";
	} 
	
	@GetMapping("/log")
    public String logExample() {
		logger.debug("This is a DEBUG message");
		logger.info("This is an INFO message");
		logger.warn("This is a WARN message");
		logger.error("This is a ERROR message");
		return "Check logs for details!";
	}
	
	@GetMapping("/testError")
    public String generateError() {
		throw new RuntimeException("Simulated error");
	}
	
	@LogExecutionTime
	@GetMapping("/time")
    public String executionTime() throws InterruptedException {
		Thread.sleep(500);
		return "Method execution completed";
	}
}
