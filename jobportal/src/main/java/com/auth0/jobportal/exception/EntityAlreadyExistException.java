package com.auth0.jobportal.exception;


public class EntityAlreadyExistException extends RuntimeException {

  public EntityAlreadyExistException(String message) {
    super(message);
  }
}
