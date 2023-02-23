package io.algostrategy.client.bitmart.exception;

import io.algostrategy.client.bitmart.BitmartApiError;

/**
 * An exception which can occur while invoking methods of the Bitmart API.
 */
public class BitmartApiException extends RuntimeException {

    private static final long serialVersionUID = 2100953594382262101L;

    private BitmartApiError error;

    public BitmartApiException(BitmartApiError error) {
        this.error = error;
    }

    public BitmartApiException() {
        super();
    }

    public BitmartApiException(String message) {
        super(message);
    }

    public BitmartApiException(Throwable cause) {
        super(cause);
    }

    public BitmartApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Bitmart API.
     */
    public BitmartApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
