package com.tarvel.basic.exception;

/**
 * Service级异常
 *
 * @author luffy
 * @date 15/6/2
 */
public class ServiceException extends BusinessRuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception e) {
        super(message, e);
    }
}
