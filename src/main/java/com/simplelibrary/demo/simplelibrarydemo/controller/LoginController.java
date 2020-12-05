package com.simplelibrary.demo.simplelibrarydemo.controller;

import com.simplelibrary.demo.simplelibrarydemo.dao.RegisterBookRepository;
import com.simplelibrary.demo.simplelibrarydemo.entity.RegisterBook;
import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import com.simplelibrary.demo.simplelibrarydemo.service.StudentService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class LoginController {

    private StudentService studentService;

    @Autowired
    private ShowDueController showDueController;


    @Autowired
    public LoginController(StudentService theStudentService){
        studentService = theStudentService;
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "fancy-login";
    }

    @GetMapping("/")
    public String home() {
        System.out.println(" I am in Boom");
        return "home";
    }


    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @GetMapping("/showDue")
    public String showDue(Model theModel){

        String userName = getLoggedInUserName();

        theModel.addAttribute("userName", userName);

        Student theStudent = studentService.findByUsername(userName);

        return showDueController.getRegisteredBookUser(theStudent, theModel);
    }


    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
