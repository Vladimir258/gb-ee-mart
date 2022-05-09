package ru.gb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Задача контроллера будет заключаться в передаче сообщения и возврате
// имени представления index.html.
@Controller
public class WelcomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Добро пожаловать в магазин");
        return "index";
    }
}
