package pl.deptala.piotr.onlineshop.api.exceptions;

public class ShoppingNotFoundException extends Exception {

    public ShoppingNotFoundException(String message) {
        super(message);
    }

    public ShoppingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
