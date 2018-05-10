/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionjava;

/**
 *
 * @author nhat
 */
public class Book {
    private String bookID;
    private String bookName;
    private String author;
    private String price;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Book(String bookID, String bookName, String author, String price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }
    
   
}
