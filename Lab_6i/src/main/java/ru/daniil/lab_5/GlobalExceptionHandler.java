package ru.prokhor.lab_5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
		logger.error("An error occurred: {}", e.getMessage());
		return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException ex) {
        if (ex.getErrorId()=="1") logger.error("Фатальная ошибка: {}", ex.getErrorMsg()); 
        if (ex.getErrorId()=="2") logger.warn("Нефатальная ошибка: {}", ex.getErrorMsg());
		return new ResponseEntity<>("Ошибка!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}