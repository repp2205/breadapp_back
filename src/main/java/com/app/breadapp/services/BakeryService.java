package com.app.breadapp.services;

import com.app.breadapp.dtos.bakerydtos.BakeryDTO;

import java.util.List;

public interface BakeryService {
    List<BakeryDTO> getBakeryAndBranchs();
}
