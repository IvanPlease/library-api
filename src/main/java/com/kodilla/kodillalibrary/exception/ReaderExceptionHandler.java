package com.kodilla.kodillalibrary.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class ReaderExceptionHandler {
    public ResponseEntity<String> handleReaderException(ReaderException e) {
        log.error("Exception occurred! " + e.getMessage());
        return new ResponseEntity<>("Sorry !" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
