package com.app.breadapp.repositories;

import com.app.breadapp.entities.BranchOffice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchOfficeRepository extends CrudRepository<BranchOffice,Integer> {
    List<BranchOffice> findAllByBakeryIdAndStatus(Integer bakerId, Integer status);
    @Query(value = "SELECT c.id, c.name, c.description, c.category, c.image, b.quantity, b.amount FROM breadapp.branchoffice a INNER JOIN breadapp.productBranch b ON a.id = b.branchOffice_Id INNER JOIN breadapp.product c ON b.product_id = c.id WHERE a.id = :branchId" , nativeQuery = true)
    List<Object> findBranchProductsByBranchId(Integer branchId);
}
