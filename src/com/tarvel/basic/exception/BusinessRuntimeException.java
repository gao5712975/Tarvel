package com.tarvel.basic.exception;

/**
 * 基础runtime exception
 *
 * @author luffy
 * @date 15/5/4
 */
public class BusinessRuntimeException extends RuntimeException {

    public BusinessRuntimeException() {
        super();
    }

    public BusinessRuntimeException(String message) {
        super(message);
    }

    public BusinessRuntimeException(String message, Exception e) {
        super(message, e);
    }
}
