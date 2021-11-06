package com.constructWeek3.assure.exception;

public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword(String msg) {
        super(msg);
    }
}
