package org.example.Controllers;

import org.hibernate.annotations.NotFound;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UsernameNotFoundException.class)
    public String userNotFound(){
        System.out.println("UserNotFound");
        return "redirect:/delete";
    }

}
