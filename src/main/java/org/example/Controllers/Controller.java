package org.example.Controllers;
import org.example.Entity.User;
import org.example.Service.UserDetailsServiceImpl;
import org.example.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public String defPage(){
        return "hello";
    }
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }
    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }
    @GetMapping("/access_denied")
    public String UnauthorizedPage(){
        return "access_denied";
    }
    @GetMapping("/signup")
    public String signUpPage(){
        return "signup";
    }
    @PostMapping("/register")
    public String register(User user){
        userService.createUser(user);
        return "redirect:/login";
    }
    @GetMapping("/delete")
    public String deleteUserPage(Model model){
        model.addAttribute("users",userService.listAll());
        return "deleteUser";
    }
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String username,Model model){
        userService.deleteUser(username);
        model.addAttribute("error","Cant delete self account");
        return "redirect:/delete";
    }

}
