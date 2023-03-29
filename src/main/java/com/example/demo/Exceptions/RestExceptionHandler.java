package com.example.demo.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex , HttpHeaders headers, HttpStatus status, WebRequest requets){

        String error="Malformed JSON Request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST,error,ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
        return new ResponseEntity<Object>(apiError,apiError.getStatus());
    }


    @ExceptionHandler(InternalServerException.class)
    protected ResponseEntity<Object> handleInternalServer(InternalServerException exception){
        ApiError apiError= new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(exception.getMessage());
        return buildResponseEntity(apiError);
    }

}
