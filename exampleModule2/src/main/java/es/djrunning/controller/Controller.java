package es.djrunning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private static final String greetings = "Greetings from module 2!";

    @RequestMapping("/")
    public String index() {
        return greetings;
    }
}