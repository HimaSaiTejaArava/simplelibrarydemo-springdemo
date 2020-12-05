package com.simplelibrary.demo.simplelibrarydemo.controller;

import com.simplelibrary.demo.simplelibrarydemo.entity.RegisterBook;
import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import com.simplelibrary.demo.simplelibrarydemo.service.RegisterBookServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RegisterBookController {

    private RegisterBookServcie registerBookServcie;

    @Autowired
    public RegisterBookController(RegisterBookServcie theRegisterBookServcie){
        registerBookServcie = theRegisterBookServcie;
    }

    @GetMapping("/booksRegisteredList")
    public String booksRegisteredList(Model theModel) {

        System.out.println("I am in Students List");

        // get customers from the service
        List<RegisterBook> theRegisterBooks = registerBookServcie.findAll();

        // add the customers to the model
        theModel.addAttribute("registeredBooks", theRegisterBooks);

        return "list-registeredBooks";
    }

    @GetMapping("/registerBookForm")
    public String registerBookForm(Model theModel){

        RegisterBook theRegisterBook= new RegisterBook();

        System.out.println(theRegisterBook);

        theModel.addAttribute("registerBook", theRegisterBook);

        return "register-book-to-student";
    }

    @PostMapping("/saveRegisterBook")
    public String saveRegisterBook(@ModelAttribute("registerBook") RegisterBook theRegisterBook) {

        // save the customer using our service
        registerBookServcie.save(theRegisterBook);
        return "redirect:/booksRegisteredList";
    }

    @GetMapping("/showBookRegistrationUpdate")
    public String showBookRegistrationUpdate(@RequestParam("registrationId") int theId,
                                             Model theModel) {

        System.out.println(" I am in Registration update");

        // get the customer from the service
        RegisterBook theRegisterBook = registerBookServcie.findById(theId);

        // set the customer as a model attribute to pre - populate the form
        theModel.addAttribute("registerBook", theRegisterBook);

        // send over to our form

        return "register-book-to-student";
    }

    @GetMapping("/deleteBookRegistration")
    public String deleteBookRegistration(@RequestParam("registrationId") int theId){

        System.out.println("I am Delete");
        registerBookServcie.deleteById(theId);

        return "redirect:/booksRegisteredList";
    }
}
