package com.strozi.recipe.controller;

import com.strozi.recipe.domain.Category;
import com.strozi.recipe.domain.UnitOfMeasure;
import com.strozi.recipe.repository.CategoryRepository;
import com.strozi.recipe.repository.UnitOfMeasureRepository;
import com.strozi.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Getting index page");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
