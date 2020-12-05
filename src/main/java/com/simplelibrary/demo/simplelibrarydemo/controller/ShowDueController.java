package com.simplelibrary.demo.simplelibrarydemo.controller;

import com.simplelibrary.demo.simplelibrarydemo.dao.RegisterBookRepository;
import com.simplelibrary.demo.simplelibrarydemo.entity.RegisterBook;
import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import com.simplelibrary.demo.simplelibrarydemo.service.RegisterBookServcie;
import com.simplelibrary.demo.simplelibrarydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Optional;


@Controller
public class ShowDueController {

    private RegisterBookServcie registerBookServcie;

    @Autowired
    public ShowDueController(RegisterBookServcie theRegisterBookServcie){
        registerBookServcie = theRegisterBookServcie;
    }

    public String getRegisteredBookUser(Student theStudent, Model theModel){

        RegisterBook theRegisterBook = registerBookServcie.findById(theStudent.getId());

        Date dueDate = theRegisterBook.getDate();

        theModel.addAttribute("date", dueDate);

        return "showDue";
    }

}
