package com.constructWeek3.assure.exception;

import com.constructWeek3.assure.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomizedException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidAgeOfMemberException.class)
    public final ResponseEntity<Object> handleInvalidAgeException(Exception e, WebRequest request) {
        ExceptionDTO ex = new ExceptionDTO(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

}
