package shop.exeception.Customer;

public class CustomerUpdateExeption extends RuntimeException{
    public CustomerUpdateExeption(String message) {
        super(message);
    }
}
