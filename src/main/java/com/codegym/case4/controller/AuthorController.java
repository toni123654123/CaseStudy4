package com.codegym.case4.controller;

import com.codegym.case4.model.Author;
import com.codegym.case4.model.Book;
import com.codegym.case4.service.MyAuthorService;
import com.codegym.case4.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class AuthorController {
@Autowired
    private MyAuthorService myAuthorService;
@Autowired
    private MyBookService myBookService;


    @GetMapping("/author")
    public ModelAndView listAuthor(){
        Iterable<Author> provinces = myAuthorService.findAll();
        ModelAndView modelAndView = new ModelAndView("author/list");
        modelAndView.addObject("authors", provinces);
        return modelAndView;
    }
    @GetMapping("/author/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("author/create");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }
    @PostMapping("/author/create")
    public ModelAndView createAuthor(Author author){
        myAuthorService.save(author);
        ModelAndView modelAndView = new ModelAndView("author/create", "author", new Author());
        modelAndView.addObject("message", "new author created successfully");
        return modelAndView;
    }
    @GetMapping("/view-author/{id}")
    public ModelAndView viewAuthor(@PathVariable("id") Long id){
        Optional<Author> author = myAuthorService.findById(id);
        if(author == null){
            return new ModelAndView("author/list");
        }

        Iterable<Book> book = myBookService.findAllByAuthor(author.get());

        ModelAndView modelAndView = new ModelAndView("/author/view");
        modelAndView.addObject("author", author);
        modelAndView.addObject("books", book);
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView editAuthor(@PathVariable Long id) {
        Optional<Author> author = myAuthorService.findById(id);
        ModelAndView modelAndView = new ModelAndView("author/edit");
        if (author != null) {
            modelAndView.addObject("author", author);
        } else {
            modelAndView.addObject("message", "unknown author ");
        }
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateAuthor(@ModelAttribute("author") Author author) {
        myAuthorService.save(author);
        ModelAndView modelAndView = new ModelAndView("/author/edit");
        modelAndView.addObject("author", author);
        modelAndView.addObject("message", " author updated successfully");
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteAuthor(@PathVariable Long id) {
        myAuthorService.remove(id);
        ModelAndView modelAndView = new ModelAndView("/author/list");
        modelAndView.addObject("message", " author updated successfully");
        return modelAndView;
    }

}
