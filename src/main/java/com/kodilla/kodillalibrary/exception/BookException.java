package com.kodilla.kodillalibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookException extends RuntimeException {
    public static final String ERR_BOOK_NOT_FOUND_EXCEPTION = "Book not found";
    public static final String ERR_BOOK_ID_MUST_BE_NULL_OR_0_EXCEPTION = "Book ID must be null or 0!";
    public static final String ERR_BOOK_NOT_EXIST_EXCEPTION = "Book not existing";
    public static final String ERR_BOOK_ID_MUST_BE_NOT_NULL_EXCEPTION = "Book ID must not be null";

    public BookException(String message) {
        super(message);
    }
}
