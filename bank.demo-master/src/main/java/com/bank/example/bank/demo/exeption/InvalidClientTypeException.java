package com.bank.example.bank.demo.exeption;

public class InvalidClientTypeException extends RuntimeException {
    public InvalidClientTypeException(String s) {
        System.out.println(s);
    }
}
