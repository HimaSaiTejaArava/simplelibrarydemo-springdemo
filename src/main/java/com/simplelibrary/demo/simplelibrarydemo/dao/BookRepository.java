package com.simplelibrary.demo.simplelibrarydemo.dao;

import com.simplelibrary.demo.simplelibrarydemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
