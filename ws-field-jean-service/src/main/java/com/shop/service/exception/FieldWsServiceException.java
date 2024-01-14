package com.shop.service.exception;

public class FieldWsServiceException extends RuntimeException{
    public static final long serialVersionUID=1L;

    public FieldWsServiceException(){
        super();
    }
    public FieldWsServiceException(String message){
        super();
    }
    public FieldWsServiceException(Throwable cause){
        super(cause);
    }
    public FieldWsServiceException(String message, Throwable cause){
        super(message,cause);
    }
}
