package com.simplelibrary.demo.simplelibrarydemo.service;

import com.simplelibrary.demo.simplelibrarydemo.dao.StudentRepository;
import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository) {
        studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {

        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if(result.isPresent()) {
            theStudent = result.get();
        }
        else {
            throw new RuntimeException("Did not find student id : " + theId);
        }

        return theStudent;
    }

    @Override
    public Student findByUsername(String userName) {

        Student theStudent = studentRepository.findByUsername(userName);

        System.out.println(theStudent.getUserName() + " i am the student from customer native query");

        return theStudent;
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
