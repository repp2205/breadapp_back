package com.app.breadapp.services.impl;

import com.app.breadapp.dtos.bakerydtos.BakeryDTO;
import com.app.breadapp.dtos.bakerydtos.BrachDTO;
import com.app.breadapp.entities.Bakery;
import com.app.breadapp.entities.BranchOffice;
import com.app.breadapp.repositories.BakeryRepository;
import com.app.breadapp.repositories.BranchOfficeRepository;
import com.app.breadapp.services.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BakeryServiceImpl implements BakeryService {

    @Autowired
    BakeryRepository bakeryRepository;

    @Autowired
    BranchOfficeRepository branchOfficeRepository;

    @Override
    public List<BakeryDTO> getBakeryAndBranches() {
        List<BakeryDTO> bakeryBranchDTOList = new ArrayList<>();
        List<Bakery> bakeryList = bakeryRepository.findAllByStatus(1);

        for (Bakery bakery : bakeryList) {
            BakeryDTO bakeryDTO = new BakeryDTO();
            List<BrachDTO> branchDTOList = new ArrayList<>();
            bakeryDTO.setId(bakery.getId());
            bakeryDTO.setName(bakery.getName());
            bakeryDTO.setNit(bakery.getNit());
            bakeryDTO.setAddress(bakery.getAddress());
            bakeryDTO.setSupportEmail(bakery.getSupportEmail());
            bakeryDTO.setContactPhone(bakery.getContactPhone());
            bakeryDTO.setStatus(bakery.getStatus());
            List<BranchOffice> branchOfficeList = branchOfficeRepository.findAllByBakeryIdAndStatus(bakery.getId(), 1);
            fillBranchList(branchOfficeList, branchDTOList);
            bakeryDTO.setCampus(branchDTOList);
            bakeryBranchDTOList.add(bakeryDTO);
        }

        return bakeryBranchDTOList;
    }

    @Override
    public List<BrachDTO> getBranchesByBakeryId(Integer bakeryId){
        List<BranchOffice> branchOfficeList = branchOfficeRepository.findAllByBakeryIdAndStatus(bakeryId, 1);
        List<BrachDTO> branchDTOList = new ArrayList<>();
        fillBranchList(branchOfficeList, branchDTOList);

        return branchDTOList;
    }

    private void fillBranchList(List<BranchOffice> branchOfficeList, List<BrachDTO> brachDTOList) {
        for (BranchOffice branchOffice : branchOfficeList) {
            BrachDTO branchDto = new BrachDTO();
            branchDto.setId(branchOffice.getId());
            branchDto.setBakeryId(branchOffice.getBakeryId());
            branchDto.setName(branchOffice.getName());
            branchDto.setContactPhone(branchOffice.getContactPhone());
            branchDto.setAddress(branchOffice.getAddress());
            branchDto.setOpeningTime(branchOffice.getOpeningTime());
            branchDto.setClosingTime(branchOffice.getClosingTime());
            branchDto.setStatus(branchOffice.getStatus());
            brachDTOList.add(branchDto);
        }
    }
}
