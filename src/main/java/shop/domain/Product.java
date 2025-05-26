package shop.domain;

import java.util.Objects;

public class Product {
    private Long id;
    private String title;
    private double price;
    private boolean active;

    public double getPrice() {
        return price;
    }

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

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return String.format("%nProduct: id - %d, title - %s, price - %.2f, active - %s%n", id, title, price, active ? "yes" : "no");
    }
}
