package com.bakerysystem.repo;

import com.bakerysystem.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    public List<Ingredient> findByAmount(int amount); // returns a list because two or more Ingredients may have the same amount

}
