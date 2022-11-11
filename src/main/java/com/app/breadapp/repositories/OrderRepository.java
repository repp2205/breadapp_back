package com.app.breadapp.repositories;

import com.app.breadapp.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

    @Query(value = "SELECT b.id idOrder, b.order_date, b.pick_up_time, b.status, e.id idProduct, e.name nameProduct, e.category, e.image, d.quantity, d.total_amount FROM breadapp.user a inner join breadapp.order b on a.id = b.user_id inner join breadapp.branchoffice c on b.branchOffice_id = c.id inner join breadapp.orderProduct d on b.id = d.order_id inner join breadapp.product e on d.product_id = e.id where a.id = :userId", nativeQuery = true)
    List<Object> findByUserIdAndBranchOfficeId(Integer userId);
}
