package com.strozi.recipe.controller;

import com.strozi.recipe.domain.Category;
import com.strozi.recipe.domain.UnitOfMeasure;
import com.strozi.recipe.repository.CategoryRepository;
import com.strozi.recipe.repository.UnitOfMeasureRepository;
import com.strozi.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
