package com.app.exercise.controller.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.exercise.exception.CommonException;
import com.app.exercise.exception.GenericException;
import com.app.exercise.model.generic.BaseResult;

import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TransactionSystemException.class)
	ResponseEntity<?> handleConstraintViolationException(TransactionSystemException e) {
		List<BaseResult> errorList = new ArrayList<>();

		if (e.getRootCause() instanceof ConstraintViolationException) {
			ConstraintViolationException constraintViolationException = (ConstraintViolationException) e.getRootCause();

			constraintViolationException.getConstraintViolations().stream().forEach(item -> {
				errorList.add(new BaseResult(item.getMessage()));
			});
			logger.error(errorList);

		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

	@ExceptionHandler(value = { GenericException.class, Exception.class, SignatureException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException exception, WebRequest request) {
		BaseResult resultMessage = new BaseResult();
		HttpStatus httpStatus = null;
		if (exception instanceof CommonException) {
			GenericException exceptionResult = (GenericException) exception;
			httpStatus = exceptionResult.getStatus();
			resultMessage = new BaseResult(exceptionResult.getMessage());
		} 
		else {
			resultMessage = new BaseResult("ERROR DESCONOCIDO DE SERVIDOR");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		logger.error(resultMessage.getMessage());
		return handleExceptionInternal(exception, resultMessage, new HttpHeaders(), httpStatus, request);
	}

}