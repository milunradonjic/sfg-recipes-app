package com.milunradonjic.recipes.controllers;

import com.milunradonjic.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
//
//    @RequestMapping({"", "/", "/index"})
//    public String getIndexPage(Model model) {
//        log.debug("Request to get index page");
//        model.addAttribute("recipes", recipeService.findAll());
//        return "index";
//    }
}
