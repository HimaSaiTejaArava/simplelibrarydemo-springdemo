package com.simplelibrary.demo.simplelibrarydemo.dao;

import com.simplelibrary.demo.simplelibrarydemo.entity.RegisterBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterBookRepository extends JpaRepository<RegisterBook, Integer> {
}
