package com.app.breadapp.services;

import com.app.breadapp.dtos.orderdtos.OrderIdDTO;
import com.app.breadapp.dtos.orderdtos.OrderRegisterDTO;
import com.app.breadapp.dtos.orderdtos.OrderUserDTO;

import java.text.ParseException;
import java.util.List;

public interface OrderService {
    List<OrderUserDTO> getOrder(Integer userId, Integer branchOfficeId) throws Exception;
    OrderIdDTO registerOrder(OrderRegisterDTO orderRegisterDTO) throws ParseException;
}
