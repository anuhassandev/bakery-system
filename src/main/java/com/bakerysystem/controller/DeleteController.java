package com.bakerysystem.controller;

import com.bakerysystem.model.Bakery;
import com.bakerysystem.model.Bread;
import com.bakerysystem.model.Ingredient;
import com.bakerysystem.repo.BakeryRepository;
import com.bakerysystem.repo.BreadRepository;
import com.bakerysystem.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {
    @Autowired
    private IngredientRepository i_repo;
    @Autowired
    private BreadRepository br_repo;
    @Autowired
    private BakeryRepository ba_repo;

    @RequestMapping("/deleteBakery")
    public String deletebakery (Model model, @RequestParam (value = "id") int BakeryID) {
        for (Bakery bakery : ba_repo.findAll()) {
            if (bakery.getId() == BakeryID) {
                ba_repo.delete(bakery);
            }
        }
        return ("redirect:/list");
    }



    @RequestMapping("/deleteBread")
    public String deleteBread(Model model, @RequestParam(value="type") String breadType) {
        for (Bakery bakery : ba_repo.findAll()) {
            if (bakery.getBreads().contains(br_repo.findByType(breadType))) {
                bakery.getBreads().remove(br_repo.findByType(breadType));
            }

            if (bakery.getMostPopular() != null) {
                if (bakery.getMostPopular().getType().equals(breadType)) {
                    bakery.setMostPopular(null);
                }
            }
        }

        for (Bread bread : br_repo.findAll()) {
            if (bread == br_repo.findByType(breadType)) {
                br_repo.delete(bread);
            }
        }
        return ("redirect:/list");
    }


        @RequestMapping("/deleteIngredient")
        public String deleteingredient (Model model, @RequestParam (value = "id") int IngredientID)
        {
            for (Bread bread : br_repo.findAll()) {
                if (bread.getIngredients().contains(i_repo.findById(IngredientID).get())) {
                    bread.getIngredients().remove(i_repo.findById(IngredientID).get());
                }

                if (bread.getFilling() != null) {
                        if (bread.getFilling().getId() == IngredientID) {
                            bread.setFilling(null);
                        }
                }
            }


            for (Ingredient ingredient : i_repo.findAll()) {
                if (ingredient.getId() == IngredientID) {
                    i_repo.delete(ingredient);
                }
            }

            return ("redirect:/list");
        }
    }
