package shop.controller;

import shop.domain.Customer;
import shop.service.CustomerService;

import java.util.List;

public class CustomerController {
    private final CustomerService service;

    public CustomerController() {
        service = new CustomerService();
    }

    public Customer save(String name) {
        Customer customer = new Customer(name);
        return service.save(customer);

    }


    public List<Customer> getAllActiveCustomers() {
        return service.getAllActiveCustomer();

    }

    public Customer getActiveCustomerById(Long id) {
        return service.getActiveCustomerById(id);
    }

    public void update(Long id, String newName) {
        service.update(id, newName);
    }

    public void deleteById(Long id) {
        service.deleteById(id);
    }

    public void deleteByName(String name) {
        service.deleteByName(name);
    }

    public void restoreById(Long id) {
        service.restoreById(id);
    }

    public int getAllActiveCusomersNumber() {
        return service.getAllActiveCusomersNumber();
    }

    public double getCustomersCartTotalCost(Long customerId) {
        return service.getCustomersCartTotalCost(customerId);
    }

    public double getCustomersCartAveragePrice(Long customerId) {
        return getCustomersCartAveragePrice(customerId);

    }

    public void addProductToCustomerCart(Long customerId, Long productId) {
        service.addProductToCustomerCart(customerId, productId);
    }

    public void removeProductFromCustomersCart(Long customerId, Long productId) {
        service.removeProductFromCustomersCart(customerId, productId);
    }

    public void clearCustomersCart(Long customerId) {
        service.clearCustomersCart(customerId);
    }
}

