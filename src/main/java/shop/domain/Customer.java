package shop.domain;

import java.util.List;
import java.util.Objects;

public class Customer {
    private Long id;
    private String name;
    private boolean active;
    private List<Product> cart;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return active == customer.active && Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(cart, customer.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active, cart);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\n");
        builder.append(String.format("Customer: id  - %d,name - %s,active - %s", id, name, active ? "yes" : "no"));
        builder.append("Korsina");
        cart.forEach((builder::append));
        return builder.toString();

    }

}
