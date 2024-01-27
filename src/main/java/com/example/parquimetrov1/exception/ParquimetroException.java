package com.example.parquimetrov1.exception;

import java.io.Serial;


public class ParquimetroException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ParquimetroException(String message, Exception e) {super(message, e);}

    public ParquimetroException(String message) {super(message);}

}
