package com.simplelibrary.demo.simplelibrarydemo.controller;

import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import com.simplelibrary.demo.simplelibrarydemo.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;


    @Autowired
    public StudentController(StudentService theStudentService){
        studentService = theStudentService;
    }


    @GetMapping("/students")
    public String listStudents(Model theModel) {

        System.out.println("I am in Students List");

        // get customers from the service
        List<Student> theStudents = studentService.findAll();

        // add the customers to the model
        theModel.addAttribute("students", theStudents);

        return "list-students";
    }

    @GetMapping("/showFormForAddStudent")
    public String showFormForAddStudent(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @PostMapping("/saveStudent")
    public String saveCustomer(@ModelAttribute("student") Student theStudent) {

        // save the customer using our service
        studentService.save(theStudent);


        return "redirect:/students";
    }

    @GetMapping("/showFormForUpdateStudent")
    public String showFormForUpdateStudent(@RequestParam("studentId") int theId,
                                    Model theModel) {

        // get the customer from the service
        Student theStudent = studentService.findById(theId);

        // set the customer as a model attribute to pre - populate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form

        return "student-form";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int theId){

        System.out.println("I am Delete");
        studentService.deleteById(theId);

        return "redirect:/students";
    }
}
