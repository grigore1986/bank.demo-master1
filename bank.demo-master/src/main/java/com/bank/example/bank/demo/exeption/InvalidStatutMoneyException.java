package com.bank.example.bank.demo.exeption;

public class InvalidStatutMoneyException extends RuntimeException {
    public InvalidStatutMoneyException(String s) {
        System.out.println(s);
    }
}
