package com.bank.example.bank.demo.exeption;

public class InvalidPositionException extends RuntimeException {
    public InvalidPositionException(String s) {
        System.out.println(s);
    }
}
