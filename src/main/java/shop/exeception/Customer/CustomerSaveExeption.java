package shop.exeception.Customer;

public class CustomerSaveExeption extends RuntimeException{
    public CustomerSaveExeption(String message) {
        super(message);
    }
}
