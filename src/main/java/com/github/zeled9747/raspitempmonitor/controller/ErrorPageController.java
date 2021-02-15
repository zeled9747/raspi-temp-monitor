package com.github.zeled9747.raspitempmonitor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.server.ServerRequest;

@Controller
public class ErrorPageController implements ErrorController {

    @Autowired
    DefaultErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public String error(Model model, WebRequest request) {
        Map<String, Object> error = this.errorAttributes.getErrorAttributes((ServerRequest) request,
                ErrorAttributeOptions.defaults());
        model.addAllAttributes(error);
        System.out.println(error);
        return "error/error";
    }

    @GetMapping("/notraspberry")
    public String notRaspberry() {
        return "error/notraspberry";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
