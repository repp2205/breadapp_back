package com.app.breadapp.controllers;

import com.app.breadapp.dtos.MessageErrorResponse;
import com.app.breadapp.services.BakeryService;
import com.app.breadapp.services.BranchService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "")
@RestController
@RequestMapping(value = "/brachOffice")
@Log4j2
public class BranchOfficeController {

    public static final Logger logger = LoggerFactory.getLogger(BranchOfficeController.class);
    private static final String ERROR  = "Error";



    @Autowired
    BranchService branchService;

    @GetMapping(path = "products/{branchId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProductFromBranch(@PathVariable("branchId") Integer branchId){
        try {
            logger.info("Executing service getProductFromBranch. branchId: {}", branchId);
            return ResponseEntity.status(HttpStatus.OK).body(branchService.getProductFromBranch(branchId));
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.UNAUTHORIZED);
        }
    }
}
