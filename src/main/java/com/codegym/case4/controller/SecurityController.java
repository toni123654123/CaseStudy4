package com.codegym.case4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class SecurityController {
    @RequestMapping("/user")
    public String userInfo(Model model, Principal principal) {
        return "userInfoPage";
    }

    @RequestMapping("/admin")
    public String adminPage(Model model, Principal principal) {

        return "adminPage";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }



    @RequestMapping("/")
    public String homePage() {
        return "welcomePage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "welcomePage";
    }

}
