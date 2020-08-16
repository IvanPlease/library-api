package com.kodilla.kodillalibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReaderException extends RuntimeException {
    public static final String ERR_READER_NOT_FOUND_EXCEPTION = "Reader not found";
    public static final String ERR_READER_ID_MUST_BE_NOT_NULL_EXCEPTION = "Reader ID must not be null";
    public static final String ERR_READER_ID_MUST_BE_NULL_OR_0_EXCEPTION = "Reader ID must be null or 0!";
    public static final String ERR_READER_NOT_EXIST_EXCEPTION = "Reader not existing";
    public static final String ERR_READER_BLACKLIST_EXCEPTION = "Reader is blacklisted, pay for lost book";

    public ReaderException(String message) {
        super(message);
    }
}
