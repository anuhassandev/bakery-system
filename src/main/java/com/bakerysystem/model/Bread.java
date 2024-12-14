package com.bakerysystem.model;

import com.bakerysystem.model.Bakery;

import javax.persistence.*;
import java.util.List;
@Entity
public class Bread {
    @Id

    private String type; //PK
    @ManyToMany(mappedBy = "breads")
    private List<Bakery> bakeries;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER) // If a bread is deleted, all its ingredients should be deleted too. 
                                                                      // If a bread is loaded, all its ingredients should be loaded too.

    @JoinColumn(name = "fk_bread_type") //A bread can have multiple ingredients but one ingredients can only belong to one bread.
    private List<Ingredient> ingredients;

    @OneToOne(cascade = CascadeType.ALL) //A bread can have only one filling which belongs to one bread.
    private Ingredient filling;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Bakery> getBakeries() {
        return bakeries;
    }

    public void setBakeries(List<Bakery> bakeries) {
        this.bakeries = bakeries;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getFilling() {
        return filling;
    }

    public void setFilling(Ingredient filling) {
        this.filling = filling;
    }


    @Override
    public String toString() {
        return "Bread{" +
                "type='" + type + '\'' +
                ", ingredients=" + ingredients +
                ", filling=" + filling +
                '}';
    }
}
