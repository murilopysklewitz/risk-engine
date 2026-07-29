package com.risk.manager.domain;

public class InvalidTransactionId extends RuntimeException {
    public InvalidTransactionId() {
        super("Invalid Transaction Id ");
    }
}
