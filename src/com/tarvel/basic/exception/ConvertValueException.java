package com.tarvel.basic.exception;

/**
 * 转换值异常
 *
 * @author luffy
 * @date 15/5/4
 */
public class ConvertValueException extends BusinessRuntimeException {

    public ConvertValueException(String message) {
        super(message);
    }

    public ConvertValueException(String message, Exception e) {
        super(message, e);
    }
}
