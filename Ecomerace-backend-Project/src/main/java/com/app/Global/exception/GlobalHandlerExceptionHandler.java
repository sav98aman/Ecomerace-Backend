package com.app.Global.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandlerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDeatils> AllTypeExceptiionHandller(Exception ex,WebRequest req){
		MyErrorDeatils err=new MyErrorDeatils(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDeatils>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
