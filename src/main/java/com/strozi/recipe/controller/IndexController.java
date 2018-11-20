package com.strozi.recipe.controller;

import com.strozi.recipe.domain.Category;
import com.strozi.recipe.domain.UnitOfMeasure;
import com.strozi.recipe.repository.CategoryRepository;
import com.strozi.recipe.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        return "index";
    }
}
