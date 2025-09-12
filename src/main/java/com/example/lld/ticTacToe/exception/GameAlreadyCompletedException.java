package com.example.lld.ticTacToe.exception;

public class GameAlreadyCompletedException extends RuntimeException {
  public GameAlreadyCompletedException(String message) {
    super(message);
  }
}
