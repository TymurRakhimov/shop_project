package shop.service;

import shop.domain.Product;
import shop.exeception.Product.ProductNotFoundExeption;
import shop.exeception.Product.ProductRestoreExeption;
import shop.exeception.Product.ProductSaveExeption;
import shop.exeception.Product.ProductUpdateExeption;
import shop.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository repository;
    private static ProductService instance;

    private ProductService() {
        repository = new ProductRepository();
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }


    public Product save(Product product) {
        if (product == null) {
            throw new ProductSaveExeption("The protected object of the product can not be null");
        }
        String title = product.getTitle();
        if (title == null || title.trim().isEmpty()) {
            throw new ProductSaveExeption("Name of protected product can not be empty");
        }
        if (product.getPrice() < 0) {
            throw new ProductSaveExeption("Price protected product can not be negative");

        }


        product.setActive(true);
        return repository.save(product);
    }

    public List<Product> getAllActiveProducts() {
        return repository.findAll()
                .stream()
                .filter(Product::isActive)
                .toList();
    }

    public Product getActiveProductById(Long id) {
        Product product = repository.findById(id);

        if (product == null || !product.isActive()) {
            throw new ProductNotFoundExeption(id);

        }
        return product;
    }


    public void update(Long id, double newPrice) {
        if (newPrice < 0) {
            throw new ProductUpdateExeption("Price updated product can not be negative");

        }
        getActiveProductById(id);
        repository.update(id, newPrice);
    }

    public void deleteById(Long id) {
        getActiveProductById(id).setActive(false);

    }

    public void deleteByTitle(String title) {
        getAllActiveProducts()
                .stream()
                .filter(x -> x.getTitle().equals(title))
                .forEach(x -> x.setActive(false));
    }

    public void restoreById(Long id) {
        Product product = repository.findById(id);
        if (product == null) {
            throw new ProductRestoreExeption(String.format("Product with id %d not found!", id));
        }
        product.setActive(true);

    }

    public int getAllActiveProductCount() {
        return getAllActiveProducts().size();

    }

    public double getAllActiveProductsTotalCost() {
        return getAllActiveProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .sum();

    }

    public double getAllActiveProductsAveragePrice() {
        int productsCount = getAllActiveProductCount();
        if (productsCount == 0) {
            return 0;
        }
        return getAllActiveProductsTotalCost() / getAllActiveProductCount();
    }


}
