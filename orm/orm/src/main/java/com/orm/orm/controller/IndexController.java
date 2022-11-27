package com.orm.orm.controller;

import com.orm.orm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
