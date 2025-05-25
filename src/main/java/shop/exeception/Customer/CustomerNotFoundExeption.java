package shop.exeception.Customer;

public class CustomerNotFoundExeption extends RuntimeException {
    public CustomerNotFoundExeption(Long id) {
        super(String.format("Customer with id %d not found!", id));
    }
}
