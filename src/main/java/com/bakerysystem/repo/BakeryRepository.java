package com.bakerysystem.repo;

import com.bakerysystem.model.Bakery;
import com.bakerysystem.model.Bread;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BakeryRepository extends CrudRepository<Bakery, Integer> {
    public Bakery findByAddress(String address); // no two bakeries should have the same address so it should return ONE bakery
    public List<Bakery> findByMostPopular(Bread mostPopular); // returns a list because 2 or more bakeries can have the same bread as its most popular

}
