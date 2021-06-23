package com.murali;

import com.murali.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(RuntimeException exception) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("BOOK-SERVICE-400");
        errorResponse.setErrorDesc(exception.getLocalizedMessage());
        log.error("exception encounted in book service={}", exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
