package com.jesucompany.ejerciciospringboot.view.controllers.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexWebController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
