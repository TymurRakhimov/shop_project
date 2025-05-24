package shop.repository;

import shop.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> database;
    private long currentId;

    public CustomerRepository() {
        database = new ArrayList<>();
        database.add((new Customer(1L, "Vasya", true)));
        database.add((new Customer(2L, "Petya", true)));
        database.add((new Customer(3L, "Ivan", true)));
        currentId = 3;
    }


    public Customer save(Customer customer) {
        customer.setId(++currentId);
        database.add(customer);
        return customer;
    }

    public Customer findById(Long id) {
        //    for (Customer customer : database) {
        //      if (customer.getId().equals(id)) {
        //        return customer;
        //  }
        // }
        //return null;

        return database.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> findAll() {
        return database;
    }

    public void update(Long id, String newName) {
        database.removeIf(x -> x.getId().equals(id));

    }
}
