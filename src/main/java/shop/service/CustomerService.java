package shop.service;

import shop.domain.Customer;
import shop.domain.Product;
import shop.exeception.Customer.CustomerNotFoundExeption;
import shop.exeception.Customer.CustomerRestoreExeption;
import shop.exeception.Customer.CustomerSaveExeption;
import shop.exeception.Customer.CustomerUpdateExeption;
import shop.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository repository;
    private final ProductService productService;

    public CustomerService() {
        repository = new CustomerRepository();
        productService = ProductService.getInstance();
    }


    public Customer save(Customer customer) {
        if (customer == null) {
            throw new CustomerSaveExeption("The retained customer cannot be null!");

        }

        String name = customer.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new CustomerSaveExeption("Name of retained customer cannot be empty!");

        }

        customer.setActive(true);
        return repository.save(customer);

    }


    public List<Customer> getAllActiveCustomer() {
        return repository.findAll()
                .stream()
                .filter(Customer::isActive)
                .toList();

    }

    public Customer getActiveCustomerById(Long id) {
        Customer customer = repository.findById(id);
        if (customer == null || !customer.isActive()) {
            throw new CustomerNotFoundExeption(id);

        }
        return customer;
    }

    public void update(Long id, String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new CustomerUpdateExeption("New name of retained customer cannot be empty!");
        }
        getActiveCustomerById(id);
        repository.update(id, newName);
    }

    public void deleteById(Long id) {
        getActiveCustomerById(id).setActive(false);
    }

    public void deleteByName(String name) {
        getAllActiveCustomer()
                .stream()
                .filter(x -> x.getName().equals(name))
                .forEach(x -> x.setActive(false));
    }

    public void restoreById(Long id) {
        Customer customer = repository.findById(id);
        if (customer == null) {
            throw new CustomerRestoreExeption(
                    String.format("Customer with id %d not found!", id)
            );
        }
        if (customer.isActive()) {
            throw new CustomerRestoreExeption(
                    String.format("Customer with id %d is active!", id)
            );
        }
        customer.setActive(true);
    }

    public int getAllActiveCusomersNumber() {
        return getAllActiveCustomer().size();

    }

    public double getCustomersCartTotalCost(Long customerId) {
        return getActiveCustomerById(customerId)
                .getCart()
                .stream()
                .filter(Product::isActive)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public double getCustomersCartAveragePrice(Long customerId) {
        return getActiveCustomerById(customerId)
                .getCart()
                .stream()
                .filter(Product::isActive)
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

    }

    public void addProductToCustomerCart(Long customerId, Long productId) {
        Customer customer = getActiveCustomerById(customerId);
        Product product = productService.getActiveProductById(productId);
        customer.getCart().add(product);
    }

    public void removeProductFromCustomersCart(Long customerId, Long productId) {
        Customer customer = getActiveCustomerById(customerId);
        Product product = productService.getActiveProductById(productId);
        customer.getCart().remove(product);
    }

    public void clearCustomersCart(Long customerId) {
        getActiveCustomerById(customerId).getCart().clear();
    }
}