package com.simplelibrary.demo.simplelibrarydemo.service;

import com.simplelibrary.demo.simplelibrarydemo.entity.Book;
import com.simplelibrary.demo.simplelibrarydemo.entity.RegisterBook;

import java.util.List;

public interface RegisterBookServcie {

    public List<RegisterBook> findAll();

    public RegisterBook findById(int theId);

    public void save(RegisterBook theRegisterBook);

    public void deleteById(int theId);
}
