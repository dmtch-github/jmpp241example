package jm.security.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }

//    @GetMapping(value = "/login")
//    public String getLoginPage() {
//        return "login12";
//    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //как здесь получить имя аутентифицированного пользователя???
        model.addAttribute("user_name", auth.getName());
        return "user";
    }

    @GetMapping(value = "/admin")
    public String getAdminPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //как здесь получить имя аутентифицированного пользователя???
        model.addAttribute("user_name", auth.getName());
        return "admin";
    }

}
