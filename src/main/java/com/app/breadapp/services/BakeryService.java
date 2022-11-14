package com.app.breadapp.services;

import com.app.breadapp.dtos.bakerydtos.BakeryDTO;
import com.app.breadapp.dtos.bakerydtos.BrachDTO;

import java.util.List;

public interface BakeryService {
    List<BakeryDTO> getBakeryAndBranches();
    List<BrachDTO> getBranchesByBakeryId(Integer bakeryId);
}
