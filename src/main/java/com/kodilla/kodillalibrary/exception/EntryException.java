package com.kodilla.kodillalibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntryException extends RuntimeException {
    public static final String ERR_ENTRY_NOT_FOUND = "Entry not found";
    public static final String ERR_ENTRY_ID_MUST_BE_NOT_NULL_EXCEPTION = "Entry ID must not be null";
    public static final String ERR_ENTRY_ID_MUST_BE_NULL_OR_0_EXCEPTION = "Entry ID must be null or 0!";
    public static final String ERR_ENTRY_NOT_EXIST_EXCEPTION = "Entry not existing";

    public EntryException(String message) {
        super(message);
    }
}
