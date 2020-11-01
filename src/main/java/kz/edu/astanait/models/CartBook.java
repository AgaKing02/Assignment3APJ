package kz.edu.astanait.models;

import java.util.ArrayList;
import java.util.List;

public class CartBook {
    private List<Book> bookList;

    public CartBook(List<Book> bookList) {
        this.bookList = bookList;
    }

    public CartBook() {
        bookList=new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

}
