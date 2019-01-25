package com.raymond.entrypoint;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Raymond Kwong on 12/1/2018.
 */
@Qualifier("handlerExceptionResolver")
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ErrorResponseBean handleAuthenticationException(AuthenticationException exception, HttpServletResponse response){
        ErrorResponseBean errorResponseBean = new ErrorResponseBean();
        errorResponseBean.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
        errorResponseBean.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        return errorResponseBean;
    }
}