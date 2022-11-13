package com.app.breadapp.repositories;

import com.app.breadapp.entities.OrderProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProducRepository extends CrudRepository<OrderProduct,Integer> {

}
