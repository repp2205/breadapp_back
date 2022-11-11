package com.app.breadapp.repositories;

import com.app.breadapp.entities.Bakery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BakeryRepository extends CrudRepository<Bakery,Integer> {
    List<Bakery> findAllByStatus(Integer status);
}
