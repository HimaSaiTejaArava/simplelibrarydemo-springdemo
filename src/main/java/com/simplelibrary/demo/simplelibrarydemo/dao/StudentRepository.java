package com.simplelibrary.demo.simplelibrarydemo.dao;

import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM users WHERE username = ?1", nativeQuery = true)
    Student findByUsername(String userName);
}
