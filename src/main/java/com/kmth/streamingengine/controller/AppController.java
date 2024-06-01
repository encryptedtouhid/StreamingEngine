package com.kmth.streamingengine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/App")
public class AppController {
    @GetMapping("/my-endpoint")
    public String myEndpoint() {
        return "Hello, World!";
    }
}
