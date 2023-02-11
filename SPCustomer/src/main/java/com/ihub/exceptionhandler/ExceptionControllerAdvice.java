package com.ihub.exceptionhandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> exceptionhandler(NoSuchElementException noSuchElementException)
	{
	
		return new ResponseEntity<String>("input data is empty or null, do the needful", HttpStatus.BAD_REQUEST);
		
		
	}
	
	@ExceptionHandler(IhubException.class)
	public ResponseEntity<String> ihubexceptionhandler(IhubException ihubException)
	{
		return new ResponseEntity<String>("Data is missing", HttpStatus.BAD_REQUEST);
		
	}

}
