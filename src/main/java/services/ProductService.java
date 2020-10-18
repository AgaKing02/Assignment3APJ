package services;

import models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);

    Product getProductByName(String name);
}
