package com.kmth.streamingengine.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Custom logic to handle errors
        return "error"; // returns the name of the error view
    }

}
