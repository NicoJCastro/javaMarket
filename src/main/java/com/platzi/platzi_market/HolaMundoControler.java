package com.platzi.platzi_market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/saludar")

public class HolaMundoControler {

    @GetMapping("/hola")

    public String saludar(){
        return "Logrando usar Java en Spring Boot";
    }
}
