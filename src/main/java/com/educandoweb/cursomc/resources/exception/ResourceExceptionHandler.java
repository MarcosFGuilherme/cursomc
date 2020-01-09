 package com.educandoweb.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.educandoweb.cursomc.services.exception.AuthorizationException;
import com.educandoweb.cursomc.services.exception.DataIntegrityException;
import com.educandoweb.cursomc.services.exception.FileException;
import com.educandoweb.cursomc.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public  ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

		StandardError err = new  StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Nao Encontrado.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public  ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){

		StandardError err = new  StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de Dados.", e.getMessage(), request.getRequestURI()); 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<StandardError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de Validacao.", e.getMessage(), request.getRequestURI());
				
		for(FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(),f.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public  ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request){

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso Negado.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
		
	}
	
	@ExceptionHandler(FileException.class)
	public  ResponseEntity<StandardError> file(FileException e, HttpServletRequest request){

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro de Arquivo.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}

	@ExceptionHandler(AmazonServiceException.class)
	public  ResponseEntity<StandardError> amazonService(AmazonS3Exception e, HttpServletRequest request){
		
		HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
		StandardError err = new StandardError(System.currentTimeMillis(), code.value(), "Erro no AmazonService.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(code).body(err);
		
	}
	
	@ExceptionHandler(AmazonClientException.class)
	public  ResponseEntity<StandardError> amazonClient(AmazonClientException e, HttpServletRequest request){

		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro no AmazonClient.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
	
	@ExceptionHandler(AmazonS3Exception.class)
	public  ResponseEntity<StandardError> amazonS3(AmazonS3Exception e, HttpServletRequest request){
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro no Amazon S3.", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
}
