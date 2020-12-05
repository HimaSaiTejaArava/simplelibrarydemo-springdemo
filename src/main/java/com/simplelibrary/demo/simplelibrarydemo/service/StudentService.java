package com.simplelibrary.demo.simplelibrarydemo.service;

import com.simplelibrary.demo.simplelibrarydemo.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int theId);

    public Student findByUsername(String userName);

    public void save(Student theStudent);

    public void deleteById(int theId);
}
