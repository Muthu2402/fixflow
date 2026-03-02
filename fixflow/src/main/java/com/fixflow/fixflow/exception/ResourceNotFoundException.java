package com.fixflow.fixflow.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
          super(message);
    }
}
