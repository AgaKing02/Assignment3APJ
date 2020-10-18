package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product implements Comparable<Product> {

    public int id;

    public String name;

    public String description;

    public int price=0;

    public String size="M";

    public String image_url;

    public String category;


    public Product(String name, String description, int price, String size, String image_url, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.image_url = image_url;
        this.category = category;
    }

    public Product(int id, String name, String description, int price, String size, String image_url, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.image_url = image_url;
        this.category = category;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", image_url='" + image_url + '\'' +
                ", category='" + category + '\'' +
                '}';
    }


    @Override
    public int compareTo(Product o) {
        int out= (int) o.getPrice();
        return this.price-out;
    }
}
