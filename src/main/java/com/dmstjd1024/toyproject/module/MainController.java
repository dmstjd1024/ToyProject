package com.dmstjd1024.toyproject.module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){

        return "index";
    }

    @GetMapping("/checkout")
    public String checkout(){

        return "checkout";
    }

    @GetMapping("/product")
    public String product(){

        return "product";
    }

}

