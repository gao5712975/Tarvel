package com.tarvel.basic.exception;

/**
 * dao异常
 *
 * @author luffy
 * @date 15/6/3
 */
public class DaoAccessException extends BusinessRuntimeException {

    public DaoAccessException() {
        super();
    }

    public DaoAccessException(String message) {
        super(message);
    }

    public DaoAccessException(String message, Exception e) {
        super(message, e);
    }
}
