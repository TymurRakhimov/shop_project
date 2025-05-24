package shop.domain;

import java.util.Objects;

public class Product {
    private Long id;
    private String title;
    private double price;
    private boolean active;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Double.compare(price, product.price) == 0 && active == product.active && Objects.equals(id, product.id) && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, active);


    }


    public Product(Long id, String title, double price, boolean active) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.active = active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%nProduct: id - %d, title - %s, price - %.2f, active - %s%n", id, title, price, active ? "yes" : "no");
    }
}
