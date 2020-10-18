package services.implementations;

import interfaces.ProductRepository;
import models.Product;
import repository.ProductRepositoryImpl;
import services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductbyID(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }
}
