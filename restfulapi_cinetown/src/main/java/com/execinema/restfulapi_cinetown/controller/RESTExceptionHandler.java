package com.execinema.restfulapi_cinetown.controller;

import com.execinema.restfulapi_cinetown.exception.ResourceNotFoundException;
import com.execinema.restfulapi_cinetown.exception.WrongParamFormatException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {

        //Se volessi usare un messaggio personale effettivamente scritto da me per quella data eccezione, chiamare all'interno
        // del metodo exceptionParamether.getMessage();
        return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WrongParamFormatException.class})
    public ResponseEntity<Object> handleWrongParamFormatException(WrongParamFormatException exception, WebRequest request){
        return new ResponseEntity<Object>( exception.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<Object>( errors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}

