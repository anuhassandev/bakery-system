package com.bakerysystem.repo;

import com.bakerysystem.model.Bread;
import org.springframework.data.repository.CrudRepository;

public interface BreadRepository extends CrudRepository<Bread, String> {

    public Bread findByType(String type); // type is the PK of Bread so it should only return one bread since no two breads should have the same type.
}
