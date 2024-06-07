package com.spasov.testmvc.exception;

public class ShopNotFoundException extends RuntimeException {
    public ShopNotFoundException(Long id) {
        super("Shop not found: " + id);
    }
}
