package interfaces;

import models.Product;

import java.util.List;

public interface ProductRepository extends EntityRepository<Product> {
    List<Product> getAllProducts();

    Product getProductbyID(int id);

    Product getProductByName(String name);


}
