package kz.edu.astanait.models;

public class Book implements Comparable<Book> {
    private int isbn;
    private String name;
    private String author;
    private String image;
    private int stock = 0;

    public Book(int isbn, String name, String author, int stock) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.stock = stock;
    }

    public Book(String name, String author, String image, int stock) {
        this.name = name;
        this.author = author;
        this.image = image;
        this.stock = stock;
    }

    public Book(int isbn, String name, String author, String image, int stock) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.image = image;
        this.stock = stock;
    }

    public Book() {
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                '}';
    }


    @Override
    public int compareTo(Book o) {
        return this.stock - o.stock;
    }
}
