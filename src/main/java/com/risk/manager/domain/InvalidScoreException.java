package com.risk.manager.domain;

public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(int score) {
        super("Invalid score:" + score);
    }
}
