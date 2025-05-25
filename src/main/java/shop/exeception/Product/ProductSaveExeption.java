package shop.exeception.Product;

public class ProductSaveExeption extends RuntimeException{
    public ProductSaveExeption(String message) {
        super(message);
    }
}
