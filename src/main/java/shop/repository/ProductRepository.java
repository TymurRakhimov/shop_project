package shop.repository;

import shop.domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {

    private Map<Long, Product> database;
    private long currentId;

    public ProductRepository() {
        database = new HashMap<>();


        database.put(1L, new Product(1L, "Banana", 120, true));
        database.put(2L, new Product(2L, "Apple", 80, true));
        database.put(3L, new Product(3L, "Orange", 230, true));
        database.put(4L, new Product(4L, "Peach", 190, true));
        database.put(5L, new Product(5L, "Lemon", 140, true));
        currentId = 5;
    }

    public Product save(Product product) {

        product.setId(++currentId);
        database.put(currentId, product);
        return product;
    }


    public Product getById(Long id) {
        return database.get(id);
    }


    public List<Product> findAll() {
        return new ArrayList<>(database.values());
    }

    public void update (Long id,double newPrice){
        database.get(id).setPrice(newPrice);
    }

        public void  deleteById (Long id){
        database.remove(id);

        }

}
