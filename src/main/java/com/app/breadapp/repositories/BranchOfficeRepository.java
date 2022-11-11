package com.app.breadapp.repositories;

import com.app.breadapp.entities.BranchOffice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchOfficeRepository extends CrudRepository<BranchOffice,Integer> {
    List<BranchOffice> findAllByBakeryIdAndStatus(Integer bakerId, Integer status);
}
