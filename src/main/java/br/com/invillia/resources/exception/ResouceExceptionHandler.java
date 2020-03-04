package br.com.invillia.resources.exception;

import br.com.invillia.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException,
                                                        HttpServletRequest httpServletRequest){

        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(),
                System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);

    }
}
