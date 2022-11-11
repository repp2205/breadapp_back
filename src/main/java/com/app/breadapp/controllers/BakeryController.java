package com.app.breadapp.controllers;

import com.app.breadapp.dtos.MessageErrorResponse;
import com.app.breadapp.services.BakeryService;
import com.app.breadapp.services.OrderService;
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
@RequestMapping(value = "/bakery")
@Log4j2
public class BakeryController {

    public static final Logger logger = LoggerFactory.getLogger(BakeryController.class);
    private static final String ERROR  = "Error";



    @Autowired
    BakeryService bakeryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBakeryAndBranchs(){
        try {
            logger.info("Executing service getBakeryAndBranchs");
            return ResponseEntity.status(HttpStatus.OK).body(bakeryService.getBakeryAndBranchs());
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.UNAUTHORIZED);
        }
    }
}
