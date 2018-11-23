/**
 * 
 */
package com.openpmoapi.exceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-03
*/
@ControllerAdvice
public class OpenPmoExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String usermessage = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		List<Erro> error = Arrays.asList(new Erro(usermessage, developerMessage));
		return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Erro> error = criarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, error, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		String usermessage = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<Erro> error = Arrays.asList(new Erro(usermessage, developerMessage));
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler({ DataIntegrityViolationException.class } )
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
		String usermessage = messageSource.getMessage("operation.not-allowed", null, LocaleContextHolder.getLocale());
		String developerMessage = ExceptionUtils.getRootCauseMessage(ex);
		List<Erro> error = Arrays.asList(new Erro(usermessage, developerMessage));
		return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criarListaDeErros(BindingResult bindingResult) {
		List<Erro> error = new ArrayList<>();
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String usermessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String developerMessage = fieldError.toString();
			error.add(new Erro(usermessage, developerMessage));
		}
			
		return error;
	}
	
	public static class Erro {
		
		private String userMessage;
		private String developerMessage;
		
		public Erro(String userMessage, String developerMessage) {
			this.userMessage = userMessage;
			this.developerMessage = developerMessage;
		}

		public String getUsermessage() {
			return userMessage;
		}

		public String getDeveloperMessage() {
			return developerMessage;
		}
		
	}
	
	
	
}
