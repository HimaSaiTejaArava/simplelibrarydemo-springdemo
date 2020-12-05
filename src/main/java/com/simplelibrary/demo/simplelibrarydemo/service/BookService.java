package com.simplelibrary.demo.simplelibrarydemo.service;

import com.simplelibrary.demo.simplelibrarydemo.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findById(int theId);

    public void save(Book theBook);

    public void deleteById(int theId);
}
