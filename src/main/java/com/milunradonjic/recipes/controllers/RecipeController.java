package com.milunradonjic.recipes.controllers;

import com.milunradonjic.recipes.domain.Recipe;
import com.milunradonjic.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String findRecipeById(@PathVariable Long id, Model model) {
        log.debug("Request to get recipe by id: {}", id);
        Recipe recipe = recipeService.findRecipeById(id);
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }
}
