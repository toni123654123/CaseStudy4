package com.codegym.case4.controller;

import com.codegym.case4.model.Book;
import com.codegym.case4.model.Category;
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

public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBookService bookService;

    @ModelAttribute("allCategories")
    public Iterable<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/admin/category")
    public ModelAndView listCategory() {
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("category/list");
            modelAndView.addObject("categorys", categories);
        return modelAndView;
    }

    @GetMapping("/admin/category/create")
    public ModelAndView showCreateCategory() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/admin/category/create")
    public ModelAndView createCategory(Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create", "category", new Category());
        modelAndView.addObject("message", "new category created successfully");
        return modelAndView;
    }

    @GetMapping("/admin/category/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/admin/category/edit")
    public ModelAndView updateCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "Updated Category successful!!!");
        return modelAndView;
    }

    @GetMapping("/admin/category/{id}/delete")
    public ModelAndView deleteAuthor(@PathVariable Long id) {
        categoryService.remove(id);
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categorys", categories);
        return modelAndView;
    }

    @GetMapping("/admin/category/{id}")
    public ModelAndView findBooksByCategoryId(@PathVariable Long id,@PageableDefault(size = 10) Pageable pageable){
        Category category = categoryService.findById(id).get();
        Page<Book> books =  bookService.findAllByCategories(id,pageable);
        ModelAndView modelAndView = new ModelAndView("/category/detail");
        modelAndView.addObject("books",books);
        modelAndView.addObject("category",category);
        return  modelAndView;
    }

    @GetMapping("/client/category/{id}")
    public ModelAndView findBooksByCategoryIdC(@PathVariable Long id,@PageableDefault(size = 10) Pageable pageable){
        Category category = categoryService.findById(id).get();
        Page<Book> books =  bookService.findAllByCategories(id,pageable);
        ModelAndView modelAndView = new ModelAndView("/category/categoryDetail");
        modelAndView.addObject("books",books);
        modelAndView.addObject("category",category);
        return  modelAndView;
    }

}

