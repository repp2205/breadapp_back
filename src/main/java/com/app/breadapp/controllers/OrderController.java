package com.app.breadapp.controllers;

import com.app.breadapp.dtos.MessageErrorResponse;
import com.app.breadapp.dtos.orderdtos.OrderRegisterDTO;
import com.app.breadapp.dtos.orderdtos.OrderStatusDTO;
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
@RequestMapping(value = "/order")
@Log4j2
public class OrderController {

    public static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static final String ERROR  = "Error";



    @Autowired
    OrderService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrder(@RequestParam(required = false) Integer userId, @RequestParam(required = false) Integer branchOfficeId){
        try {
            logger.info("Executing service getOrder. userId: {}", userId, branchOfficeId);
            return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(userId, branchOfficeId));
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registerOrder(@RequestBody OrderRegisterDTO orderRegisterDTO){
        try {
            logger.info("Executing service registerOrder");
            return ResponseEntity.status(HttpStatus.OK).body(orderService.registerOrder(orderRegisterDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.toString()),HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateOrderStatus(@PathVariable (value = "orderId") Integer orderId, @RequestBody OrderStatusDTO orderStatusDTO){
        try {
            logger.info("Executing service updateOrderStatus");
            return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrderStatus(orderStatusDTO, orderId));
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageErrorResponse(e.toString()),HttpStatus.UNAUTHORIZED);
        }
    }
}
