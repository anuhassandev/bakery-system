package com.bakerysystem.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Bakery {
    @Id @GeneratedValue //The primary keys of Bakery and Ingredient should be generated automatically.
    private int id; //PK
    private String address;
    @ManyToMany (cascade = {CascadeType.MERGE})
    private List<Bread> breads;
    @ManyToOne()
    @JoinColumn(name="fk_mostPopularBread_type")
    private Bread mostPopular;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bread> getBreads() {
        return breads;
    }

    public void setBreads(List<Bread> breads) {
        this.breads = breads;
    }

    public Bread getMostPopular() {
        return mostPopular;
    }

    public void setMostPopular(Bread mostPopular) {
        this.mostPopular = mostPopular;
    }


    @Override
    public String toString() {
        return "Bakery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", breads=" + breads +
                ", mostPopular=" + mostPopular +
                '}';
    }
}
