package com.simplelibrary.demo.simplelibrarydemo.controller;

import com.simplelibrary.demo.simplelibrarydemo.entity.Book;
import com.simplelibrary.demo.simplelibrarydemo.entity.Student;
import com.simplelibrary.demo.simplelibrarydemo.service.BookService;
import com.simplelibrary.demo.simplelibrarydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService theBookService){
        bookService = theBookService;
    }

    @GetMapping("/books")
    public String listBooks(Model theModel) {

        System.out.println("I am in Students List");

        // get customers from the service
        List<Book> theBooks = bookService.findAll();

        // add the customers to the model
        theModel.addAttribute("books", theBooks);

        return "list-books";
    }

    @GetMapping("/showFormForAddBook")
    public String showFormForAddBook(Model theModel) {

        // create model attribute to bind form data
        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book theBook) {

        // save the customer using our service
        bookService.save(theBook);

        return "redirect:/books";
    }

    @GetMapping("/showFormForUpdateBook")
    public String showFormForUpdateBook(@RequestParam("bookId") int theId,
                                           Model theModel) {

        // get the customer from the service
        Book theBook = bookService.findById(theId);

        // set the customer as a model attribute to pre - populate the form
        theModel.addAttribute("book", theBook);

        // send over to our form

        return "book-form";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int theId){

        System.out.println("I am Delete");
        bookService.deleteById(theId);

        return "redirect:/books";
    }

}
