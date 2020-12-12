package com.bridgelabz.employeepayrollapp.excpetions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.utility.Response;

@ControllerAdvice
@RestController
public class GlobalException {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<Response> handleCustomEmployeeException(EmployeeException empEx) {
		Response response = new Response(empEx.getStatusCode(), empEx.getMsg());

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ExceptionHandler(JWTException.class)
	public ResponseEntity<Response> handleJWTException(JWTException jwtExcption) {
		Response response = new Response(jwtExcption.getStatusCode(), jwtExcption.getMessage());

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleException(Exception exception) {
		Response response = new Response(500, "Internal Server Exception");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(UserLoginException.class)
	public ResponseEntity<Response> handleUserException(UserLoginException userLoginException){
		Response response = new Response(123, "Login Error");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	

}
