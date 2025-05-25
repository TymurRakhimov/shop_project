package shop.exeception.Product;

public class ProductRestoreExeption extends RuntimeException {
    public ProductRestoreExeption(String message) {
        super(message);
    }
}
