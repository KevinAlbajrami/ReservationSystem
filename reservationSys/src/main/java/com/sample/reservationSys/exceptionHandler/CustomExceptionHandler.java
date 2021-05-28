package com.sample.reservationSys.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

		@Override
	   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       String error = "Malformed JSON request";
	       return buildResponseEntity(new ExceptionResponse(HttpStatus.BAD_REQUEST, error, ex));
	   }

	   private ResponseEntity<Object> buildResponseEntity(ExceptionResponse apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
	   
		
		@ExceptionHandler(AccessDeniedException.class)
		protected ResponseEntity<Object> handleAccessDenied(AccessDeniedException ex) {
			ExceptionResponse apiError = new ExceptionResponse(HttpStatus.FORBIDDEN);
			apiError.setMessage(ex.getMessage());
			return buildResponseEntity(apiError);
		}
		
}