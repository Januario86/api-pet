package com.pet.api.exceptions.handler;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.pet.api.exceptions.BusinessException;
import com.pet.api.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
		problemDetail.setTitle("Recurso não encontrado");
		problemDetail.setType(URI.create("https://api.petshop.com/errors/not-found"));
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setProperty("instance", request.getDescription(false));
		return problemDetail;
	}

	@ExceptionHandler(BusinessException.class)
	public ProblemDetail handleBusinessException(BusinessException ex, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
		problemDetail.setTitle("Erro de negócio");
		problemDetail.setType(URI.create("https://api.petshop.com/errors/business-error"));
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setProperty("instance", request.getDescription(false));
		return problemDetail;
	}

	@ExceptionHandler(Exception.class)
	public ProblemDetail handleGlobalException(Exception ex, WebRequest request) {
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
				"Ocorreu um erro inesperado no servidor.");
		problemDetail.setTitle("Erro interno do servidor");
		problemDetail.setType(URI.create("https://api.petshop.com/errors/internal-server-error"));
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setProperty("instance", request.getDescription(false));
		return problemDetail;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleValidationExceptions(MethodArgumentNotValidException ex) {

		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setType(URI.create("https://api.meusistema.com/erros/argumento-invalido"));
		problemDetail.setTitle("Erro de validação");
		problemDetail.setDetail("Um ou mais campos estão inválidos. Verifique os detalhes.");

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		problemDetail.setProperty("errors", errors);

		return problemDetail;
	}
}
