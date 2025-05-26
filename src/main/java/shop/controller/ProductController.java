package shop.controller;

import shop.domain.Product;
import shop.service.ProductService;

import java.util.List;

public class ProductController {
    private final ProductService service;

    public ProductController() {
        service = ProductService.getInstance();
    }

    public Product save(String title, double price) {
        Product product = new Product(title, price);
        return service.save(product);
    }

    public List<Product> getAllActiveProducts() {
        return service.getAllActiveProducts();
    }

    public Product getActiveProductById(Long id) {
        return service.getActiveProductById(id);
    }


    public void update(Long id, double newPrice) {
        service.update(id, newPrice);
    }

    public void deleteById(Long id) {
        service.deleteById(id);
    }

    public void deleteByTitle(String title) {
        service.deleteByTitle(title);
    }

    public void restoreById(Long id) {
        service.restoreById(id);

    }

    public int getAllActiveProductCount() {
        return service.getAllActiveProductCount();
    }

    public double getAllActiveProductsTotalCost() {
        return service.getAllActiveProductsTotalCost();

    }

    public double getAllActiveProductsAveragePrice() {
        return service.getAllActiveProductsAveragePrice();

    }


}
