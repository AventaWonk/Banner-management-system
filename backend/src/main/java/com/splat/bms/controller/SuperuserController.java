package com.splat.bms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/superuser")
public class SuperuserController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
