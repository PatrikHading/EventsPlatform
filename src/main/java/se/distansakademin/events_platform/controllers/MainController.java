package se.distansakademin.events_platform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/") // http://localhost:8080/
    public String getHome(){
        return "home";
    }
}
