package com.bakerysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id @GeneratedValue //The primary keys of Bakery and Ingredient should be generated automatically.
    private int id; //PK
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
