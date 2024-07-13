package com.javid.product.exception;

public class NotAvailableQuantityException extends RuntimeException {
    public NotAvailableQuantityException(String msg) {
        super(msg);
    }
}
