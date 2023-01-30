package com.example.segurityapp.exceptions;

import java.util.*;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> responseBody = new LinkedHashMap<>();

		responseBody.put("timestamp", new Date());
		responseBody.put("status", status.value());

		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> listErrors = new ArrayList<>();

		for (FieldError fieldError : fieldErrors) {
			String errorMessage = fieldError.getDefaultMessage();
			listErrors.add(errorMessage);
		}

		responseBody.put("errors", listErrors);
		return new ResponseEntity<>(responseBody, headers, status);
	}

}
