package com.codegym.case4.controller;

import com.codegym.case4.service.IAuthorService;
import com.codegym.case4.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class BookController {
    @Autowired
    private MyBookService myBookService;
    @Autowired
    private IAuthorService iAuthorService;
}
