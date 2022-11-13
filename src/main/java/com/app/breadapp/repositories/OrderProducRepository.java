package com.app.breadapp.repositories;

import com.app.breadapp.entities.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProducRepository extends CrudRepository<OrderProduct,Integer> {

}
