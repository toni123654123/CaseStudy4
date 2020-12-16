package com.codegym.case4.controller;

import com.codegym.case4.model.Author;
import com.codegym.case4.model.Book;
import com.codegym.case4.model.Category;
import com.codegym.case4.service.Author.IAuthorService;
import com.codegym.case4.service.Book.IBookService;
import com.codegym.case4.service.Category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private IAuthorService iAuthorService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("allCategories")
    public Iterable<Category> getAllCategories() {
        return categoryService.findAll();
    }


    @GetMapping("/admin/author")
    public ModelAndView listAuthor(@PageableDefault(size = 10) Pageable pageable) {
        Page<Author> authors = iAuthorService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("author/list");
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @GetMapping("/admin/author/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("author/create");
        modelAndView.addObject("author", new Author());
        return modelAndView;
    }

    @PostMapping("/admin/author/create")
    public ModelAndView createAuthor(Author author) {
        iAuthorService.save(author);
        ModelAndView modelAndView = new ModelAndView("author/create", "author", new Author());
        modelAndView.addObject("message", "new author created successfully");
        return modelAndView;
    }

    @GetMapping("/admin/author/{id}/edit")
    public ModelAndView editAuthor(@PathVariable Long id) {
        Optional<Author> author = iAuthorService.findById(id);
        ModelAndView modelAndView = new ModelAndView("author/edit");
        if (author != null) {
            modelAndView.addObject("author", author);
        } else {
            modelAndView.addObject("message", "unknown author ");
        }
        return modelAndView;
    }

    @PostMapping("/admin/author/edit")
    public ModelAndView updateAuthor(@ModelAttribute("author") Author author) {
        iAuthorService.save(author);
        ModelAndView modelAndView = new ModelAndView("/author/edit");
        modelAndView.addObject("author", author);
        modelAndView.addObject("message", " author updated successfully");
        return modelAndView;
    }

    @GetMapping("/admin/author/{id}/delete")
    public ModelAndView deleteAuthor(@PathVariable Long id,@PageableDefault(size = 10) Pageable pageable) {
        iAuthorService.remove(id);
        Page<Author> authors = iAuthorService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("author/list");
        modelAndView.addObject("authors", authors);
        return modelAndView;

    }

    @GetMapping("/admin/author/{id}")
    public ModelAndView authorDetail(@PathVariable Long id,@PageableDefault(size = 10) Pageable pageable){
        Page<Book> books = bookService.findAllByAuthorId(id, pageable);
        Author author = iAuthorService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/author/detail");
        modelAndView.addObject("books",books);
        modelAndView.addObject("author",author);
        return  modelAndView;
    }
    @GetMapping("/client/author/{id}")
    public ModelAndView authorDetailC(@PathVariable Long id,@PageableDefault(size = 10) Pageable pageable){
        Page<Book> books = bookService.findAllByAuthorId(id, pageable);
        Author author = iAuthorService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("/author/detailClient");
        modelAndView.addObject("books",books);
        modelAndView.addObject("author",author);
        return  modelAndView;
    }
    @GetMapping("/client/author")
    public ModelAndView listAuthorC(@PageableDefault(size = 10) Pageable pageable) {
        Page<Author> authors = iAuthorService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("author/listClient");
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }
}
