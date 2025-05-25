package shop.exeception.Product;

public class ProductUpdateExeption extends RuntimeException {
    public ProductUpdateExeption(String message) {
        super(message);
    }
}
