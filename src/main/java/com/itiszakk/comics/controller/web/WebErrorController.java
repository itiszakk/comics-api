package com.itiszakk.comics.controller.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebErrorController implements ErrorController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${controller.web.character.domain}")
    private String controllerDomain;

    @RequestMapping("/error")
    String handleError(Model model) {
        model.addAttribute("applicationName", applicationName);
        model.addAttribute("controllerDomain", controllerDomain);

        return "error";
    }
}
