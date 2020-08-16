package com.kodilla.kodillalibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RentException extends RuntimeException {
    public static final String ERR_RENT_NOT_FOUND_EXCEPTION = "Rent not found";
    public static final String ERR_RENT_ID_MUST_BE_NOT_NULL_EXCEPTION = "Rent ID must not be null";
    public static final String ERR_RENT_ID_MUST_BE_NULL_OR_0_EXCEPTION = "Rent ID must be null or 0!";
    public static final String ERR_RENT_NOT_EXIST_EXCEPTION = "Rent not existing";
    public static final String ERR_RENT_LOST_AWAITING_PAYMENT_EXCEPTION = "Rent wasn't finalized, pay for lost book and try again";

    public RentException(String message) {
        super(message);
    }
}
