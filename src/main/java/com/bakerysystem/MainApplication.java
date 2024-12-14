package com.bakerysystem;

import com.bakerysystem.model.Bakery;
import com.bakerysystem.model.Bread;
import com.bakerysystem.model.Ingredient;
import com.bakerysystem.repo.BakeryRepository;
import com.bakerysystem.repo.BreadRepository;
import com.bakerysystem.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

        @Autowired
        private IngredientRepository i_repo;
        @Autowired
        private BreadRepository br_repo;
        @Autowired
        private BakeryRepository ba_repo;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //In com.bakerysystem.MainApplication, create and store at one instance of every class from com.bakerysystem.model.
        Bread sourdough = new Bread();
        sourdough.setType("Sourdough");


        // id is auto generated for Ingredients
        Ingredient cranberry = new Ingredient();
        cranberry.setAmount(1000);

        // sourdoughMix so we can add it as an ingredient for the bread
        Ingredient sMix = new Ingredient();
        sMix.setAmount(250);

        // id is auto generated for Bakeries
        Bakery bestBakery = new Bakery();
        bestBakery.setAddress("121 Amazing Avenue");

        //save them before we start dealing with the relationships
        sourdough = br_repo.save(sourdough);
        cranberry = i_repo.save(cranberry);
        sMix = i_repo.save(sMix);
        bestBakery = ba_repo.save(bestBakery);

        //relationships
        sourdough.setFilling(cranberry);
        sourdough.setBakeries(Arrays.asList(bestBakery)); // initialises a list with one item being bestBakery. bestBakery is one of the bakeries that sells sourdough.
        sourdough.setIngredients(Arrays.asList(cranberry, sMix)); // sourdough mix is one of the ingredients required to make sourdough bread. Cranberry is its filling so it should be here too.

        bestBakery.setBreads(Arrays.asList(sourdough)); // bestBakery bas sourdough as one of its breads.
        bestBakery.setMostPopular(sourdough); // Sourdough is the most popular bread of bestBakery

        // update all the entities now their relationships have been defined
        sourdough = br_repo.save(sourdough);
        bestBakery = ba_repo.save(bestBakery);

    }
}
