package models;

public class Order {
    public int id;
    public String username;
    public int product_id;

    public Order(int id, String username, int product_id) {
        this.id = id;
        this.username = username;
        this.product_id = product_id;
    }

    public Order(String username, int product_id) {
        this.username = username;
        this.product_id = product_id;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", product_id=" + product_id +
                '}';
    }
}
