package com.constructWeek3.assure.exception;

public class EmailNotFound extends RuntimeException {
    public EmailNotFound(String msg) {
        super(msg);
    }
}
