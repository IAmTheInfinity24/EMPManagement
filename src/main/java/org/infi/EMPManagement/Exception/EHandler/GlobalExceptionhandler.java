package org.infi.EMPManagement.Exception.EHandler;

import org.infi.EMPManagement.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionhandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<String> resourceNotFoundExceptionhandler(ResourceNotFoundException x){
        return new ResponseEntity<>(x.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<String> NullPointerExceptionhandler(NullPointerException x){
        return new ResponseEntity<>(x.getMessage(),HttpStatus.NOT_FOUND);
    }
}
