package com.simplelibrary.demo.simplelibrarydemo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="register_book")
public class RegisterBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="book_id")
    private int bookId;

    @Column(name="due_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    public RegisterBook() {
    }

    public RegisterBook(int userId, int bookId, Date date) {
        this.userId = userId;
        this.bookId = bookId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegisterBook{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", date=" + date +
                '}';
    }
}
