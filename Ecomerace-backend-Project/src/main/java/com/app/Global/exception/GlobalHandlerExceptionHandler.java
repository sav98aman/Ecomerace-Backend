package com.app.Global.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.exception.AdminException;

@ControllerAdvice
public class GlobalHandlerExceptionHandler {
	// adding adminGlobale Exceptionhandler
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDeatils> AdminExceptiionHandller(AdminException ex,WebRequest req){
		MyErrorDeatils err=new MyErrorDeatils(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDeatils>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDeatils> AllTypeExceptiionHandller(Exception ex,WebRequest req){
		MyErrorDeatils err=new MyErrorDeatils(LocalDateTime.now(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyErrorDeatils>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
