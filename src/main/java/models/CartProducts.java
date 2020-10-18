package models;

import java.util.List;

public class CartProducts {
    public List<Product> productList;

    public CartProducts(List<Product> productList) {
        this.productList = productList;
    }

    public CartProducts() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "CartProducts{" +
                "productList=" + productList +
                '}';
    }
}
