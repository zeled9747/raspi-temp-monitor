package com.github.zeled9747.raspitempmonitor.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController implements ErrorController {

    @GetMapping("/notraspberry")
    public String notRaspberry() {
        return "error/notraspberry";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
