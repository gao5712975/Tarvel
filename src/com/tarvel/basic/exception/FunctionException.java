package com.tarvel.basic.exception;

/**
 * 功能级异常
 *
 * @author luffy
 * @date 15/6/2
 */
public class FunctionException extends BusinessRuntimeException {

    public FunctionException() {
        super();
    }

    public FunctionException(String message) {
        super(message);
    }

    public FunctionException(String message, Exception e) {
        super(message, e);
    }
}
