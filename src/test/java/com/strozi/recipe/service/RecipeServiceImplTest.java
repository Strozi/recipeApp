package com.strozi.recipe.service;

import com.strozi.recipe.domain.Recipe;
import com.strozi.recipe.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipesData = new HashSet<>();
        Recipe recipe = new Recipe();
        recipesData.add(recipe);
        //mockito mocking our service to return dummy collection recipesData instedad of actual data from our repository
        when(recipeService.getRecipes()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        //we want to by sure that recipeRepository were called once and only once
        // we can verify that interactions between classes are happening as expected
        verify(recipeRepository, times(1)).findAll();
    }
}